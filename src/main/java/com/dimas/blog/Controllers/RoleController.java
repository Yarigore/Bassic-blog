package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Role;
import com.dimas.blog.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return roleService.getRoles()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@RequestParam Long id) {
        return roleService.getRolebyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return roleService.saveRole(role)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        Optional<Role> roleToChange = roleService.findRoleById(id);

        if (roleToChange.isPresent()) {
            Role existingRole = roleToChange.get();

            if (role.getRoleName() != null) {
                existingRole.setRoleName(role.getRoleName());
            }

            return roleService.saveRole(existingRole)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.ok().build());
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping
    public ResponseEntity<Role> deleteRole(Role role) {
        roleService.deleteRole(role);
        return ResponseEntity.ok(role);
    }

}
