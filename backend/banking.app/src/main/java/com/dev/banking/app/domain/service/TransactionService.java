package com.dev.banking.app.domain.service;

import com.dev.banking.app.domain.model.Account;
import com.dev.banking.app.domain.model.Transaction;
import com.dev.banking.app.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactionsByAccount(Account account)
    {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionByCustomerIdInTimeRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate)
    {
        return transactionRepository.findTransactionByCustomerIdInTimeRange(customerId, startDate, endDate);
    }
}
