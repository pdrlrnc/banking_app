package com.dev.banking.app.domain.mapper;

import com.dev.banking.app.domain.dto.TransactionDTO;
import com.dev.banking.app.domain.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction transaction)
    {
        if (transaction == null)
            return null;
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setTime(transaction.getTime());
        dto.setAmmount(transaction.getAmount());
        dto.setFromAccountNumber(transaction.getFromAccount().getNumber());
        dto.setToAccountNumber(transaction.getToAccount().getNumber());
        return dto;
    }

    public static List<TransactionDTO> toDTOList(List<Transaction> transactions)
    {
        return transactions.stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
