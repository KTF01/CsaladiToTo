package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private UserService userService;

    // teljes user listazas
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<User>> all() {
        return ResponseEntity.ok(userService.findAll());
    }

    // id alapjan egy user
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value="id") int id){
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // Ki vezeti az adott feladatot ami kiírásra került.
    @CrossOrigin
    @GetMapping("/lead/{id}")
    public ResponseEntity<User> findLeadUserTasks(@PathVariable(value="id") int id){
        return ResponseEntity.ok(userService.findLeadUserTasks(id));

    }

    // Akik egy adott Taskon ("feladaton") dolgoznak.
    @CrossOrigin
    @GetMapping("/work/{taskId}")
    public ResponseEntity<List<User>> findWorkUserTasks(@PathVariable(value="taskId") int id){
        return ResponseEntity.ok(userService.findWorkUserTasks(id));
    }

    // id alapjan torol
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable("id") int id) {
        Optional<User> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()) {
            userService.delete(optionalUser.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    // id alapján modositas
    @CrossOrigin
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable("taskId") int id) {
        Optional<Task> optionalUser = userService.findTaskById(id);

        if (optionalUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(optionalUser.save(task));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    // id alapján modositas
    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable Integer id,  @RequestBody User user){
        for(User u : userService.findAll()){
            if( u.getId() == id){
                user.setId(id);
                return ResponseEntity.ok(userRepository.save(user));
            }
        }
        return ResponseEntity.notFound().build();

    }
*/

}
