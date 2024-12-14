package com.dimas.blog.Repositories;

import com.dimas.blog.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
