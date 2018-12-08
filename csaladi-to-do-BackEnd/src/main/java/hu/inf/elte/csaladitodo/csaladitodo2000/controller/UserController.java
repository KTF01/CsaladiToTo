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
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User.Role;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.csaladitodo.csaladitodo2000.AuthenticatedUser;;

@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired 
    private AuthenticatedUser authenticatedUser;

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

    // id alapján modositas
    @CrossOrigin
    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("userId") int id) {
        Optional<User> optionalOptionalUser = userService.findUserById(id);

        if (optionalOptionalUser.isPresent()) {
            User originalUser = optionalOptionalUser.get();

            if (authenticatedUser.getUser().getRole().equals(Role.ROLE_ADMIN)) {
                user.setId(id);
                user.setTasksTolead(originalUser.getTasksTolead());
                return ResponseEntity.ok(userService.save(user));
            }
            else {
                return ResponseEntity.status(401).build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // felvetel
    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);
        user.setTasksTolead(new ArrayList());
        user.setTasksToDo(new ArrayList());

        return ResponseEntity.ok(userRepository.save(user));
    }

    // bejelentkezes
    @CrossOrigin
    @PostMapping("/sign-in")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user2 = userRepository.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(user2);
    }



}
