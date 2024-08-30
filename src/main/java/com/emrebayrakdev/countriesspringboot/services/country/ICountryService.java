package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    List<GetCountryDto> getAllCustomMapperCountries();
    List<Country> insertCountries();
    Country createCounty(Country entity);
    Country findByCodeCountry(String code);
    List<Country> parseAndSaveCountries();
    List<GetCountryDto> findByLanguageEnJPQLNative();

    List<GetCountryDto> findByLanguageJPQLNative(String language);

    List<GetCountryDto> findByLanguageEnJPQL();

    List<GetCountryDto> findByLanguageJPQL(String language);
}
