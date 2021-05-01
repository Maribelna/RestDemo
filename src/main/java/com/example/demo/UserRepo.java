package com.example.demo;

import java.util.List;

public interface UserRepo {
    void saveUser(User user);

    boolean removeUser(long id);

    User getUser(long id);

    List<User> getAllUser();
}
