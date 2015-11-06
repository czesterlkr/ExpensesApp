package com.expenses.service;

import com.expenses.entity.Expense;
import com.expenses.entity.Person;

/**
 * Created by gnester on 2015-10-29.
 */
public interface ExpenseService {

    Iterable<Expense> listAllExpenses();

    Expense getExpenseById(Integer id);

    Expense saveExpense(Expense expense);

    void deleteExpense(Integer id);

}
