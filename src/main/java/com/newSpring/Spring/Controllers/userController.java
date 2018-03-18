package com.newSpring.Spring.Controllers;


import com.newSpring.Spring.Repository.UserRepository;
import com.newSpring.Spring.hashtagHyderabad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value="/get/users", method= RequestMethod.GET)
    List<hashtagHyderabad> findAll(@RequestParam(required=false) String user){
        List<hashtagHyderabad> users = new ArrayList<>();
        if(null==user){
            Iterable<hashtagHyderabad> results = this.repository.findAll();
            results.forEach(room-> {users.add(room);});
        }else{
            hashtagHyderabad user1 = this.repository.findByUser(user);
            if(null!=user1) {
                users.add(user1);
            }
        }
        return users;
    }
    @RequestMapping(value="/ins/users", method= RequestMethod.GET)
    String insertUser(@RequestParam(required=true) String usr,@RequestParam(required=true) String pass,@RequestParam(required=true) String type){
        try {
            hashtagHyderabad newUser = new hashtagHyderabad();
            newUser.setUser(usr);
            newUser.setPass(pass);
            newUser.setType(type);
            repository.save(newUser);
            return usr + " successfully inserted";
        }catch (Exception e){
            return "Error: user not updated";
        }
    }
    @RequestMapping(value="/del/users", method= RequestMethod.GET)
    String deleteUser(@RequestParam(required=true) String usr){
        try {
            hashtagHyderabad exUser = new hashtagHyderabad();
            exUser = repository.findByUser(usr);
            repository.delete(exUser);
            return usr + " successfully deleted";
        }catch (Exception e){
            return "Error: user not deleted";
        }
    }
    @RequestMapping(value="/upd/users", method= RequestMethod.GET)
    String updateUser(@RequestParam(required=true) String usr,@RequestParam(required=true) String pass,@RequestParam(required=true) String type){
        try {
            hashtagHyderabad newUser = new hashtagHyderabad();
            newUser.setUser(usr);
            newUser.setPass(pass);
            newUser.setType(type);
            repository.save(newUser);
            return usr + " successfully updated";
        }catch(Exception e){
            return "Error: value not updated";
        }
    }
}
