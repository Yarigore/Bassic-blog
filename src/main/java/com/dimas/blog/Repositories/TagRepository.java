package com.dimas.blog.Repositories;

import com.dimas.blog.Entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
