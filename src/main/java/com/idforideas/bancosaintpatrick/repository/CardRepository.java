package com.idforideas.bancosaintpatrick.repository;

import com.idforideas.bancosaintpatrick.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findCardByNumber(String number);
}
