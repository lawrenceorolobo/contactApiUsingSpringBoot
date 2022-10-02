package com.lawrenceorolobo.contactapi.webservice.controllers;

//import org.springframework.*;

import com.lawrenceorolobo.contactapi.webservice.entities.User;
import com.lawrenceorolobo.contactapi.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "contactapi")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/addUser")
    public @ResponseBody String addUser(@RequestBody User user){
        try{

            userRepository.save(user);
            return "Saved";

        }catch (Exception e){
            return ("Failed, because of "+e);
        }
    }

    @GetMapping(path="/all")
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

    @PutMapping("/updateUser/{id}")
    public @ResponseBody String updateUser(@PathVariable Integer userId, @RequestBody User updatedUser){
        User userInstance = userRepository.findById(userId).get();
        userInstance.setUserFirstName(updatedUser.getUserFirstName());
        userInstance.setUserLastName(updatedUser.getUserLastName());
        userInstance.setUserUniqueName(updatedUser.getUserUniqueName());

        try{

            userRepository.save(userInstance);
            return "Updated";

        }catch (Exception e){
            return ("Failed, because of "+e);
        }

    }

    @GetMapping("/getUser/{userId}")
    public @ResponseBody
    Object getUser(@PathVariable Integer userId){
        try{

            User user = userRepository.findById(userId).get();

            if(user.getUserUniqueName() == null){
                return "No user with that Id";
            }

            return user;
        }catch (Exception e){

            return ("Failed, because of "+e);
        }
    }
}
