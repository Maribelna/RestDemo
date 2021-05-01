package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepoCollectionImpl implements UserRepo {
    private static UserRepoCollectionImpl instance;
    private List<User> users = new ArrayList<>();

    private UserRepoCollectionImpl() {
    }

    public static UserRepoCollectionImpl getInstance() {
        if (instance == null)
            instance = new UserRepoCollectionImpl();
        return instance;
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setId((long) (Math.random() * 100));
            users.add(user);
        } else {
            for (User u : users) {
                if (user.equals(u)) {
                    int index = users.indexOf(u);
                    users.set(index, user);
                }
            }
        }
    }

    @Override
    public boolean removeUser(long id) {
        return users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User getUser(long id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }
}
