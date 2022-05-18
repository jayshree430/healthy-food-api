package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User insertIntoUser(User user);

    void deleteUserById(Long id);

    void updateUserById(Long id, User user);
}
