package com.expenses.repository;

import com.expenses.entity.Expense;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnester on 2015-10-28.
 */
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
}
