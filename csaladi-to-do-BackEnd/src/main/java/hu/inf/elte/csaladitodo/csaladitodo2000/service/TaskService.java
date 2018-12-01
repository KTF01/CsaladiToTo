package hu.inf.elte.csaladitodo.csaladitodo2000.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.TaskRepository;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }


    public Optional<Task> findTaskById(int taskId) {
        return taskRepository.findById(taskId);
    }

    public List<Task> findLeadUserTasks(int id){
        List<Task> lista = new ArrayList<>();
        for(Task t : taskRepository.findAll()){
            if (t.getLead().getId()==id){
                lista.add(t);
            }
        }
        return lista;
    }

    public List<Task> findWorkUserTasks(int id){
        User user = null;
        for(User u : userRepository.findAll()){
            if(u.getId()==id){
                user = u;
                break;
            }
        }
        return user.getTasksToDo();
    }


    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    

}
