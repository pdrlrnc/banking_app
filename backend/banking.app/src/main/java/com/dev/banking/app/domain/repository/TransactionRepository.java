package com.dev.banking.app.domain.repository;

import com.dev.banking.app.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t " +
            "WHERE t.fromAccount.id = :accountId " +
            "OR t.toAccount.id = :accountId")
    List<Transaction> getAllTransactionsByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT DISTINCT t FROM Transaction t "+
            "LEFT JOIN t.toAccount a1 " +
            "LEFT JOIN t.fromAccount a2 " +
            "LEFT JOIN a1.customer c1 " +
            "LEFT JOIN a2.customer c2 " +
            "WHERE c1.id = :customerId " +
            "OR c2.id = :customerId " +
            "AND t.time BETWEEN :startTime AND :endTime")
    List<Transaction> findTransactionByCustomerIdInTimeRange(
            @Param("customerId")Long customerId,
            @Param("startTime")LocalDateTime startTime,
            @Param("endTime")LocalDateTime endTime);

}
