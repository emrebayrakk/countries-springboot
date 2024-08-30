package com.emrebayrakdev.countriesspringboot.repositories.country;

import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findByCode(String Code);
    @Query(value = "SELECT c.* FROM Country c JOIN Language l ON c.id = l.country_id WHERE l.name = 'en'" , nativeQuery = true)
    List<Country> findByLanguageEnJPQLNative();

    @Query(value = "SELECT c.* FROM Country c JOIN Language l ON c.id = l.country_id WHERE l.name = :language" , nativeQuery = true)
    List<Country> findByLanguageJPQLNative(String language);

    @Query("SELECT c FROM Country c JOIN c.languages l WHERE l.name = 'en'")
    List<Country> findByLanguageEnJPQL();

    @Query("SELECT c FROM Country c JOIN c.languages l WHERE l.name = :language")
    List<Country> findByLanguageJPQL(String language);
}
