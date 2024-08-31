package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCustomCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    List<GetCustomCountryDto> getAllCustomMapperCountries();
    List<Country> insertCountries();
    Country createCounty(Country entity);
    Country findByCodeCountry(String code);
    List<Country> parseAndSaveCountries();
    List<GetCustomCountryDto> findByLanguageEnJPQLNative();

    List<GetCustomCountryDto> findByLanguageJPQLNative(String language);

    List<GetCustomCountryDto> findByLanguageEnJPQL();

    List<GetCustomCountryDto> findByLanguageJPQL(String language);
}
