package com.vtrack.vtrack.service;

import com.vtrack.vtrack.dto.UserDto;
import com.vtrack.vtrack.entity.User;
import com.vtrack.vtrack.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        try {
          return  userRepository.save(user);
        }catch (Exception e){
            log.info(String.valueOf(e));
            throw e;
        }

    }
    public List<User> getAll(){
       return userRepository.findAll();
    }
    public Boolean delete(Integer userId){
         userRepository.deleteById(userId);
         return  true;
    }
    public boolean mobileNoExists(String mobileNumber){
        return userRepository.existsByMobile(mobileNumber);
    }
//    public List<User> getAllUserRoles(){
//        //return userRepository.getAllUserRoles();
//        //return userRepository.get
//    }
}
