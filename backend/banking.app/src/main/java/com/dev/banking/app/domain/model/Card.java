package com.dev.banking.app.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "card")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Card {

    public Card()
    {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "type")
    private String type;

    @OneToOne
    private Account account;
}
