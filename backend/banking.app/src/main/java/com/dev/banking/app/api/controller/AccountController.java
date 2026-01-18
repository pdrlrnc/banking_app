package com.dev.banking.app.api.controller;

import com.dev.banking.app.domain.model.Account;
import com.dev.banking.app.domain.repository.AccountRepository;
import com.dev.banking.app.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public void addAccount(Account account)
    {
        accountService.addAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts()
    {
        return accountService.findAll();
    }

}
