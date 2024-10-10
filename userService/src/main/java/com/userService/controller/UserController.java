package com.userService.controller;

import com.userService.entities.User;
import com.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;
    //create
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        System.out.println("User from controller  "+user);
       return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<User> getSingleUser(@PathVariable String username){
        return new ResponseEntity<User>(userService.getUser(username), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteSingleUser(@PathVariable String username){
        userService.deleteUser(username);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getSingleUser(){
        return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
    }









}
