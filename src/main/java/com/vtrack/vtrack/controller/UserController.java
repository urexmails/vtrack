package com.vtrack.vtrack.controller;

import com.vtrack.vtrack.dto.UserDto;
import com.vtrack.vtrack.dto.mapper.UserMapper;
import com.vtrack.vtrack.entity.User;
import com.vtrack.vtrack.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping(path="/add",
    produces= MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userDto){

        User user = userMapper.toEntity(userDto);
        user.setUserName(userDto.getMobile());
        return ResponseEntity.ok(userService.addUser(user));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll()) ;

    }
//    @GetMapping("/getallUserRoles")
//    public ResponseEntity<List<User>> getallUserRoles(){
//        return ResponseEntity.ok(userService.getAllUserRoles()) ;
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer userId){
        return ResponseEntity.ok( userService.delete(userId));

    }
}
