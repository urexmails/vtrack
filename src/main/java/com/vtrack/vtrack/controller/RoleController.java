package com.vtrack.vtrack.controller;

import com.vtrack.vtrack.entity.Role;
import com.vtrack.vtrack.repository.RoleRepository;
import com.vtrack.vtrack.service.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role roleResponse = roleService.addRole(role);
        return ResponseEntity.ok(roleResponse);

    }
    @DeleteMapping(path = "/delete/{id}")

    public  ResponseEntity<String> deleteRole(@PathVariable("id") Integer Id){
        roleService.deleteRole(Id);
        return ResponseEntity.ok("Role Deleted");
    }
    @GetMapping("/getall")
    public  ResponseEntity<List<Role>> getAllRoles(){
        return  ResponseEntity.ok(roleService.getAllRoles());

    }

}
