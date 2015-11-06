package com.expenses.utils.user;

import com.expenses.entity.User;
import com.expenses.enums.Role;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by gnester on 2015-10-30.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
