package com.expenses.bootstrap;

import com.expenses.entity.Person;
import com.expenses.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * Created by gnester on 2015-10-28.
 */
//@Component
public class PersonLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PersonRepository personRepository;

    private Logger log = Logger.getLogger(PersonLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Person u1 = new Person();
        u1.setName("Grzegorz");
        u1.setSurname("Kowalski");
        personRepository.save(u1);

        log.info("Zapisano użytkownika o id " + u1.getId());

        Person u2 = new Person();
        u2.setName("Adrian");
        u2.setSurname("Widomski");
        personRepository.save(u2);

        log.info("Zapisano użytkownika o id " + u2.getId());


    }


}
