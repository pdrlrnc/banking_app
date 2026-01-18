package com.dev.banking.app.domain.service;

import com.dev.banking.app.domain.model.Account;
import com.dev.banking.app.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> findAll()
    {
        return accountRepository.findAll();
    }

    public void addAccount(Account account)
    {
        accountRepository.save(account);
    }
}
