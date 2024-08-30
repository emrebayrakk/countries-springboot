package com.emrebayrakdev.countriesspringboot.repositories.country;

import com.emrebayrakdev.countriesspringboot.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findByCode(String Code);
}
