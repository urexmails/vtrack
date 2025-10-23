package com.vtrack.vtrack.repository;

import com.vtrack.vtrack.dto.UserDto;
import com.vtrack.vtrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
     Boolean existsByMobile(String mobile);

     //@Query(value = "SELECT *  FROM public.users u  inner join public.role r on u.role =r.role_id",nativeQuery = true)
    // @Query("SELECT * FROM public.users")
     //List<User> getAllUserRoles();
}
