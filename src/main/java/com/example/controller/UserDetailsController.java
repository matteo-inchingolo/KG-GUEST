package com.example.controller;

import com.example.model.UserDetails;
import com.example.service.AuthenticationService;
import com.example.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserDetailsController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public List<UserDetails> getAllUsers(@RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return userDetailsService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDetails> getUserById(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return userDetailsService.findById(id);
    }

    @PostMapping
    public UserDetails createUser(@RequestBody UserDetails userDetails, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return userDetailsService.createUser(userDetails);
    }

    @PostMapping("/all")
    public List<UserDetails> createUsers(@RequestBody List<UserDetails> userDetails, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return userDetailsService.createUsers(userDetails);
    }

    @PutMapping("/{id}")
    public UserDetails updateUser(@PathVariable String id, @RequestBody UserDetails userDetails, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return userDetailsService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return;
        }
        userDetailsService.deleteUser(id);
    }
}
