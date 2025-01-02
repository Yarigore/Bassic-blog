package com.dimas.blog.Service;

import com.dimas.blog.Entities.Role;
import com.dimas.blog.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<List<Role>> getRoles() {
        return Optional.of(roleRepository.findAll());
    }

    public Optional<Role> getRolebyId(Long id) {
        return roleRepository.findById(id);
    }

    public Optional<List<Role>> getRolesbyName(String name) {
        return Optional.ofNullable(roleRepository.findRoleByRoleName(name));
    }

    public Optional<Role> saveRole(Role role) {
        return Optional.of(roleRepository.save(role));
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }

}
