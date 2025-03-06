package com.idforideas.bancosaintpatrick.service;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private CardRepository cardRepository;

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
       Card card = cardRepository.findCardByNumber(number).orElseThrow(() -> new UsernameNotFoundException("Invalid card"));
       return User.builder().username(number).password(card.getPin()).build();
    }

}
