package com.userService.services;

import com.userService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

   public User saveUser(User user);

   List<User> getAllUser();

   User getUser(String userId);

   public void deleteUser(String userId);


}
