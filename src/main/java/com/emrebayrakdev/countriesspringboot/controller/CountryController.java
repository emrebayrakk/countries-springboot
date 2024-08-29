package com.emrebayrakdev.countriesspringboot.controller;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.initalizer.CountryInitializer;
import com.emrebayrakdev.countriesspringboot.services.country.ICountryService;
import com.emrebayrakdev.countriesspringboot.utils.constants.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Api.CountryConstants.baseUrl)
@AllArgsConstructor
public class CountryController {

    private final ICountryService _countryService;

    @GetMapping("/getAll")
    public List<Country> GetAllCountries(){
       return _countryService.getAllCountries();
    }

    @GetMapping("/getAllJsonFile")
    public List<Country> getAllJsonFile(){
        return CountryInitializer.readCountries();
    }

    @PostMapping("/insertAllCountry")
    public List<Country> insertCountries(){
        return _countryService.insertCountries();
    }
    @PostMapping("/createCountry")
    public ResponseEntity<GetCountryDto> insertCountry(@RequestBody CreateCountryDto entity){
        return ResponseEntity.ok(_countryService.createCounty(entity));
    }



}
