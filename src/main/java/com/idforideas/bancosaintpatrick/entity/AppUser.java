package com.idforideas.bancosaintpatrick.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "last_name", nullable = false, length = 45)
    private String surname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Card> cards;

}
