package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.User;
import com.dimas.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        return ResponseEntity.ok(userService.deleteUser(user));
    }

}
