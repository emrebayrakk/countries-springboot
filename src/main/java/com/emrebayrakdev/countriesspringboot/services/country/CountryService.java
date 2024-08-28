package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.initalizer.CountryInitializer;
import com.emrebayrakdev.countriesspringboot.repositories.country.ICountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

    private final ICountryRepository _countryRepository;

    /* public CountryService(ICountryRepository countryRepository) {
        _countryRepository = countryRepository;
    }*/

    @Override
    public List<Country> getAllCountries() {
        return _countryRepository.findAll();
    }

    @Override
    public List<Country> insertCountries() {
        var countryList = CountryInitializer.readCountries();
        _countryRepository.saveAll(countryList);
        return _countryRepository.findAll();
    }
}
