package com.expenses.service.impl;

import com.expenses.entity.Expense;
import com.expenses.repository.ExpenseRepository;
import com.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gnester on 2015-10-29.
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public Iterable<Expense> listAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Integer id) {
        return expenseRepository.findOne(id);
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseRepository.delete(id);
    }
}
