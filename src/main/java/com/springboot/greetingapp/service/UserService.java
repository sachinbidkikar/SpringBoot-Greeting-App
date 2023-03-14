package com.springboot.greetingapp.service;

import com.springboot.greetingapp.model.User;
import com.springboot.greetingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String message() {
        return "hello World";
    }

    public User insert(User user) { // creating parametsid method of return type user with object
        userRepository.save(user);  //save is inbuilt method
        return user;
    }


    public User getById(long id) {
       User data =  userRepository.findById(id).get();
        return data;
    }

    public List<User> allDetails() {
        List<User> data = (List<User>) userRepository.findAll();
        return data;
    }

    public User editGreetingById(long id, User user) {
        User result = userRepository.findById(id).get(); // by using findById() we are storing id variable & .get() is to get that id. Storing in result obj.
        result.setFirstName(user.getFirstName()); //  setter method is used to set that fisrt name.
        result.setLastName(user.getLastName());
        userRepository.save(result); // save is inbuilt repo method that is storing result
        return result;
    }

    public void deleteById(Long id) {
         userRepository.deleteById(id);
    }
    }

//    public List<User> deleteById(long id) {
//        userRepository.deleteById(id);
//        List<User> data = (List<User>) userRepository.findAll();
//        return data;
//    }
//}

