package com.expenses.controller;

import com.expenses.entity.Expense;
import com.expenses.entity.Person;
import com.expenses.service.ExpenseService;
import com.expenses.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gnester on 2015-10-29.
 */
@Controller
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    PersonService personService;

    @Autowired
    ExpenseService expenseService;

    @RequestMapping("/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("persons", personService.listAllPersons());
        return "expenseForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveExpense(Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expense/" + expense.getId();
    }

    @RequestMapping("/{id}")
    public String showExpense(@PathVariable Integer id, Model model) {
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "expenseShow";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("expenses", expenseService.listAllExpenses());
        return "expenses";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "expenseForm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
        return "redirect:/expense/all";
    }
}
