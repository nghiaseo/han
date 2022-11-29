package com.han.webservice.Controller;

import com.han.webservice.Entity.User;
import com.han.webservice.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepo.findAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity singleUser(@PathVariable Long id){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id "+id+" not found !");
        }
    }
    @PostMapping("/users")
    public ResponseEntity newUser(@RequestBody User user){
        var users = userRepo.findByUsername(user.getUsername());
        if(!users.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with username "+user.getUsername()+" existed !");
        }
        else {
           var newUser =  userRepo.save(user);
           return ResponseEntity.status(HttpStatus.OK).body(newUser);
        }

    }
}
