package org.mecerintered.vannilaform.service;

import org.mecerintered.vannilaform.dto.UserRequestObject;
import org.mecerintered.vannilaform.dto.UserResponseObject;
import org.mecerintered.vannilaform.entity.User;
import org.mecerintered.vannilaform.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repository;

    public UserService(UserRepo repository) {
        this.repository = repository;
    }

    public UserResponseObject createUser(UserRequestObject request){

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());

        User savedUser = repository.save(user);

        return new UserResponseObject(savedUser.getId(), user.getName(), user.getEmail());

    }
}
