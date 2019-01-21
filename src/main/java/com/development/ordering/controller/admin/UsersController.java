package com.development.ordering.controller.admin;

import com.development.ordering.model.User;
import com.development.ordering.service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) throws Exception{
        return userService.userCreate(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public User saveUser(@RequestBody User user, @PathVariable(value = "id") Long id) throws Exception{
        return userService.userSave(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable(value = "id") Long id){
        try {
            userService.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
