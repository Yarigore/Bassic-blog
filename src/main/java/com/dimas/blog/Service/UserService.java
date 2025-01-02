package com.dimas.blog.Service;

import com.dimas.blog.Entities.User;
import com.dimas.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<List<User>> getUsers() {
        return Optional.of(userRepository.findAll());
    }

    public Optional<User> saveUser(User user) {
        return Optional.of(userRepository.save(user));
    }

    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }

}
