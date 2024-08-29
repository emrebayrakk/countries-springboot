package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
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

    @Override
    public GetCountryDto createCounty(CreateCountryDto entity) {
        Country country = new Country();
        country.setName(entity.getName());
        country.setCode(entity.getCode());
        country.setCapital(entity.getCapital());
        country.setCurrency(entity.getCurrency());
        country.setFlagUrl(entity.getFlagUrl());
        country.setContinent(entity.getContinent());
        country.setLanguages(entity.getLanguages());
        country.setPhone(entity.getPhone());
        country.setNativeName(entity.getNativeName());
        Country savedCountry = _countryRepository.save(country);
        if(savedCountry != null) {
            GetCountryDto getCountryDto = new GetCountryDto();
            getCountryDto.setName(savedCountry.getName());
            getCountryDto.setNativeName(savedCountry.getNativeName());
            getCountryDto.setCurrency(savedCountry.getCurrency());
            return getCountryDto;
        }
        return null;
    }
}
