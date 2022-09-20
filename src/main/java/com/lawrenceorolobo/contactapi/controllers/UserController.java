package com.lawrenceorolobo.contactapi.controllers;

//import org.springframework.*;

import com.lawrenceorolobo.contactapi.entities.User;
import com.lawrenceorolobo.contactapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Controller
@RequestMapping(path = "contactapi")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addNewUser")
    public @ResponseBody String addNewUser(@RequestParam String userUniqueName,
                                           @RequestParam String userFirstName,
                                           @RequestParam String userLastName){

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUserFirstName(userFirstName);
        user.setUserLastName(userLastName);
        user.setUserUniqueName(userUniqueName);
        try{

            userRepository.save(user);
            return "Saved";

        }catch (Exception e){
            return ("Failed, because of "+e);
        }


}

    @PostMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


    @DeleteMapping("/deleteUser")
    public @ResponseBody String deleteUser(@RequestParam String userUniqueName){

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUserUniqueName(userUniqueName);
        try{

            userRepository.delete(user);
            return "Deleted";

        }catch (Exception e){
            return ("Failed, because of "+e);
        }


    }

}
