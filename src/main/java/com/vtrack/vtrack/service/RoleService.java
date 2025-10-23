package com.vtrack.vtrack.service;

import com.vtrack.vtrack.entity.Role;
import com.vtrack.vtrack.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role addRole(Role role){

        roleRepository.save(role);

        return role;

    }
    public  Boolean deleteRole(Integer roleId){

        roleRepository.deleteById(roleId);

        return  true;
    }
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
