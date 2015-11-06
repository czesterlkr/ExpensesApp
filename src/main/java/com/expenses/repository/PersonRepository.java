package com.expenses.repository;

import com.expenses.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnester on 2015-10-28.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
