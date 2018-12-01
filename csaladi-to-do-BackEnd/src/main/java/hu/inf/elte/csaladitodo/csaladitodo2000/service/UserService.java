package hu.inf.elte.csaladitodo.csaladitodo2000.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.TaskRepository;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }

    public User findLeadUserTasks(int id){
        Task task = null;
        for(Task t : taskRepository.findAll()){
            if (t.getId() == id){
                task = t;
                break;
            }
        }
        return task.getLead();
    }

    public List<User> findWorkUserTasks(int id){
        Task task = null;
        for(Task t : taskRepository.findAll()){
            if(t.getId() == id){
                task = t;
                break;
            }
        }
        return task.getWorkers();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

	
}
