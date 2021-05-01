package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveUser(@RequestParam() String name,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) Long id) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setId(id);
        UserRepo userRepo = UserRepoCollectionImpl.getInstance();
        userRepo.saveUser(user);
        return user.toString();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public boolean removeUser(@PathVariable long id) {
        UserRepo userRepo = UserRepoCollectionImpl.getInstance();
        return userRepo.removeUser(id);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User getUser(@RequestParam long id) {
        UserRepo userRepo = UserRepoCollectionImpl.getInstance();
        return userRepo.getUser(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        UserRepo userRepo = UserRepoCollectionImpl.getInstance();
        return userRepo.getAllUser();
    }

}
