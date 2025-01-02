package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.User;
import com.dimas.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.saveUser(user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {

        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isPresent()){
            User existingUser = userOptional.get();
            if (user.getName() != null){
                existingUser.setName(user.getName());
            }
            if (user.getPassword() != null){
                existingUser.setPassword(user.getPassword());
            }
            if (user.getRole() != null){
                existingUser.setRole(user.getRole());
            }

            Optional<User> updatedTag = userService.saveUser(existingUser);

            return updatedTag
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(500).build());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.deleteUser(user));
    }

}
