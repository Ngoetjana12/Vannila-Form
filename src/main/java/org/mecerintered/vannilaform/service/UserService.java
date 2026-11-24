package org.mecerintered.vannilaform.service;

import org.mecerintered.vannilaform.dto.UserResponseObject;
import org.mecerintered.vannilaform.entity.User;
import org.mecerintered.vannilaform.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo repository;

    public UserService(UserRepo repository) {
        this.repository = repository;
    }

    public UserResponseObject createUser(UserResponseObject request){

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());

        User savedUser = repository.save(user);

        return new UserResponseObject(savedUser.getId(), user.getName(), user.getEmail());

    }

    public List<UserResponseObject> getAllPeople(){

        List<UserResponseObject> allPeople = new ArrayList<>();

        for(User user: repository.findAll()){

            UserResponseObject responseDTO = new UserResponseObject(
                    user.getId(),
                    user.getName(),
                    user.getEmail()
            );

            allPeople.add(responseDTO);
        }
        return allPeople;
    }

    public UserResponseObject editUser(Long id, String newEmail){

        User user = repository.findById(id).orElseThrow(null);

        user.setEmail(newEmail);
        User editedUser = repository.save(user);

        return new UserResponseObject(editedUser.getId(), editedUser.getName(), editedUser.getEmail());
    }

    public void deleteUser(Long id) {

        repository.deleteById(id);
    }
}
