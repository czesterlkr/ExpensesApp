package com.expenses.service;

import com.expenses.dto.UserCreateForm;
import com.expenses.entity.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by gnester on 2015-10-30.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Iterable<User> getAllUsers();

    User create(UserCreateForm form);
}
