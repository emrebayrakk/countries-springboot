package com.emrebayrakdev.countriesspringboot.repositories.country;

import com.emrebayrakdev.countriesspringboot.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Long> {
}
