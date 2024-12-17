package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Role;
import com.dimas.blog.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles(){
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@RequestParam Long id){
        return roleService.getRolebyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @PutMapping
    public ResponseEntity<Role> putRole(@RequestParam Long id, @RequestBody Role role){

        Role roleToChange;

        if (Objects.equals(role.getId(), id)){

            if (roleService.findRoleById(id).isPresent()){
                roleToChange = roleService.findRoleById(id).get();
                roleToChange.setRoleName(role.getRoleName());
                return ResponseEntity.ok(roleService.createRole(roleToChange));
            }
            else return ResponseEntity.badRequest().build();
        }
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Role> deleteRole(Role role){
        roleService.deleteRole(role);
        return ResponseEntity.ok(role);
    }

}
