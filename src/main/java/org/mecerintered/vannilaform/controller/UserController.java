package org.mecerintered.vannilaform.controller;

import org.mecerintered.vannilaform.dto.UpdateUserRequest;
import org.mecerintered.vannilaform.dto.UserResponseObject;
import org.mecerintered.vannilaform.repo.UserRepo;
import org.mecerintered.vannilaform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserResponseObject createPerson(@RequestBody UserResponseObject requestObject){
        return service.createUser(requestObject);
    }

    @GetMapping
    public List<UserResponseObject> getAllPeople(){
        return service.getAllPeople();
    }

    @PutMapping("/{id}")
    public UserResponseObject editUser(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return service.editUser(id, request.newEmail());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {

        service.deleteUser(id);
    }

}
