package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Comment;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.TaskRepository;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

import hu.inf.elte.csaladitodo.csaladitodo2000.AuthenticatedUser;;
@RestController
@RequestMapping("/api/tasks")
class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired 
    private AuthenticatedUser authenticatedUser;

    // teljes feladat listazas
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Task>> all() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // id alapjan egy feladat kiszurese
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") int id){
        Optional<Task> optionalTask = taskService.findTaskById(id);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // Melyik Taskot ("feladatot") vezeti a paraméterben adott illető.
    @CrossOrigin
    @GetMapping("/lead/{id}")
    public ResponseEntity<List<Task>> findLeadUserTasks(@PathVariable(value="id") int id){
        return ResponseEntity.ok(taskService.findLeadUserTasks(id));

    }

    // Mely feladatokon dolgozik a paraméterben kapott illető.
    @CrossOrigin
    @GetMapping("/work/{workerId}")
    public ResponseEntity<List<Task>> findWorkUserTasks(@PathVariable(value="workerId") int id){
        return ResponseEntity.ok(taskService.findWorkUserTasks(id));
    }
    

    // id alapján töröl feladatot
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable("id") int id) {
        Optional<Task> optionalTask = taskService.findTaskById(id);

        if (optionalTask.isPresent()) {
            taskService.delete(optionalTask.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // felvetel
    @CrossOrigin    
    @PostMapping("")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        task.setLead(authenticatedUser.getUser());
        task.setWorkers(new ArrayList());
        task.setComments(new ArrayList());
        task.setTags(new ArrayList());
        return ResponseEntity.ok(taskService.save(task));
    }
    
    // modositas id alapjan
    @CrossOrigin
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable("taskId") int id) {
        Optional<Task> optionalOriginalTask = taskService.findTaskById(id);

        if (optionalOriginalTask.isPresent()) {
            Task originalTask = optionalOriginalTask.get();

            if (authenticatedUser.getUser().getUsername().equals(originalTask.getLead().getUsername())) {
                task.setId(id);
                task.setComments(originalTask.getComments());
                task.setWorkers(originalTask.getWorkers());
                task.setTags(originalTask.getTags());
                return ResponseEntity.ok(taskService.save(task));
            }
            else {
                return ResponseEntity.status(401).build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
