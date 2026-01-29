package com.dev.banking.app.domain.dto;

import com.dev.banking.app.domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private LocalDateTime time;
    private Double ammount;
    private String fromAccountNumber;
    private String toAccountNumber;
}
