package com.dev.banking.app.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name= "transaction")
@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    @NotNull
    private LocalDateTime time;

    @Column(name = "amount")
    @NotNull
    @Positive
    private Double amount;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "to_account_id") //money source
    private Account toAccount;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "from_account_id") //money destination
    private Account fromAccount;
}
