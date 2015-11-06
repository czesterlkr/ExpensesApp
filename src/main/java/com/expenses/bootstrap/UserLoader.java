package com.expenses.bootstrap;

import com.expenses.dto.UserCreateForm;
import com.expenses.entity.Person;
import com.expenses.entity.User;
import com.expenses.enums.Role;
import com.expenses.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by gnester on 2015-10-30.
 */
@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService;

    Logger log = Logger.getLogger(UserLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        UserCreateForm user = new UserCreateForm();
        user.setEmail("xxx@wp.pl");
        user.setPassword("xxx");
        user.setRole(Role.USER);
//        user.setPerson(new Person());
//        user.setPerosn(3);

        userService.create(user);

        log.info("Zapisano uzytkownika o adresie mail=" + user.getEmail());


    }
}
