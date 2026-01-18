package com.dev.banking.app.api.controller;

import com.dev.banking.app.domain.model.Account;
import com.dev.banking.app.domain.model.Transaction;
import com.dev.banking.app.domain.service.AccountService;
import com.dev.banking.app.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactionsByAccount(Account account)
    {
        return transactionService.getAllTransactionsByAccount(account);
    }
}
