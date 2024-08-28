package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.entities.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    List<Country> insertCountries();
}
