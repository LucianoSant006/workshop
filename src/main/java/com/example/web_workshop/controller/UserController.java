package com.example.web_workshop.controller;

import com.example.web_workshop.entities.User;
import com.example.web_workshop.repositories.UserRepository;
import com.example.web_workshop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService  userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
      List<User> list = userService.findAll();
      return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
     ResponseEntity<User> insert(@RequestBody User obj){
         obj = userService.insert(obj);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
        }
    }




