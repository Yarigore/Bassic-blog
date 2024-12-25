package com.dimas.blog.Service;

import com.dimas.blog.Entities.User;
import com.dimas.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User deleteUser(User user){
        userRepository.delete(user);
        return user;
    }

}
