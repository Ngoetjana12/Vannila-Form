package org.mecerintered.vannilaform.controller;

import org.mecerintered.vannilaform.dto.UserResponseObject;
import org.mecerintered.vannilaform.repo.UserRepo;
import org.mecerintered.vannilaform.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserResponseObject createPerson(@RequestBody UserResponseObject requestObject){
        return service.createPerson(requestObject);
    }

    @GetMapping
    public List<UserResponseObject> getAllPeople(){
        return service.getAllPeople();
    }

}
