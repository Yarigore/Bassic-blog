package com.dimas.blog.Repositories;

import com.dimas.blog.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
