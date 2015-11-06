package com.expenses.dto;

import com.expenses.entity.Person;
import com.expenses.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by gnester on 2015-10-30.
 */
@Getter
@Setter
public class UserCreateForm {

    public static final int PASSWORD_LENGTH_MIN = 8;

    private String email = "";

    private String password = "";

    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

    private Person person = new Person();
}
