package com.dev.banking.app.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
@AllArgsConstructor
public class Account {

    public Account()
    {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "balance")
    private Double balance;

    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "fromAccount") //transactions SENT from this account
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "toAccount") //transactions RECEIVED by this account
    private List<Transaction> receivedTransactions;
}
