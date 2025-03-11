package com.idforideas.bancosaintpatrick.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number", nullable = false, unique = true, length = 16)
    private String number;

    @Column(name = "pin", nullable = false, length = 64)
    private String pin;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @ManyToOne
    @JoinColumn(
            name = "user",
            referencedColumnName = "id",
            nullable = false
    )
    private AppUser user;

}
