package com.expenses.bootstrap;

import com.expenses.entity.Expense;
import com.expenses.entity.Person;
import com.expenses.repository.ExpenseRepository;
import com.expenses.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * Created by gnester on 2015-10-28.
 */
@Component
public class ExpenseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ExpenseRepository expenseRepository;

    private Logger log = Logger.getLogger(ExpenseLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Expense e1 = new Expense();
        e1.setName("butter");
        e1.setPrice((double) 4);
        expenseRepository.save(e1);

        log.info("Zapisano wydatek o id " + e1.getId());

        Expense e2 = new Expense();
        e2.setName("tomatoes");
        e2.setPrice((double) 8);
        expenseRepository.save(e2);

        log.info("Zapisano wydatek o id " + e2.getId());


    }


}
