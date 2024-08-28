package com.emrebayrakdev.countriesspringboot.repositories.country;

import com.emrebayrakdev.countriesspringboot.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country,String> {
}
