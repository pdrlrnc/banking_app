package com.dev.banking.app.api.controller;

import com.dev.banking.app.domain.dto.TransactionDTO;
import com.dev.banking.app.domain.mapper.TransactionMapper;
import com.dev.banking.app.domain.model.Account;
import com.dev.banking.app.domain.model.Transaction;
import com.dev.banking.app.domain.service.AccountService;
import com.dev.banking.app.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll()
    {
        List<Transaction> transactions = transactionService.findAll();
        List<TransactionDTO> dtos = TransactionMapper.toDTOList(transactions);
        return ResponseEntity.ok(dtos);
    }
    /**
    @GetMapping
    public ResponseEntity<List<Transaction> getAllTransactionsByAccount(Account account)
    {
        return transactionService.getAllTransactionsByAccount(account);
    }

    //2024-01-29T10:30:00Z would be a valid date
    @GetMapping("/getTransactionByCustomerIdInTimeRange/")
    public List<Transaction> getTransactionByCustomerIdInTimeRange(@RequestParam Long customerId,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime
    )
    {
        return transactionService.getTransactionByCustomerIdInTimeRange(customerId, startTime, endTime);
    }
    **/
}
