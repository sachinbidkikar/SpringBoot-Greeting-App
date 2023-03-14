package com.springboot.greetingapp.controller;

import com.springboot.greetingapp.model.User;
import com.springboot.greetingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/post")
    public User insert(@RequestBody User user){
        return userService.insert(user); // we are using userservice's method insert
    }

    @GetMapping("/hello")
    public String sayHello(){
    return userService.message();
    }

    @GetMapping("/getbyid/{id}")
    public User show(@PathVariable long id){
    User user = userService.getById(id);
    return user;
    }

    @GetMapping("/getall")
    public List<User> showall(){
    List<User> data = userService.allDetails();
    return data;
    }

    @PutMapping("/edit/{id}")
    public User editGreetingById(@PathVariable long id, @RequestBody User user) {
        return userService.editGreetingById(id,user);
    }

//    @DeleteMapping("/delete/{id}")
//    public List<User> deleteById(@PathVariable Long id){
//        userService.deleteById(id);
//        return deleteById(id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long Id){
        userService.deleteById(Id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }


}

