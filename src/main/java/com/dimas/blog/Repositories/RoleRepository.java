package com.dimas.blog.Repositories;

import com.dimas.blog.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findRoleByRoleName(String roleName);
}
