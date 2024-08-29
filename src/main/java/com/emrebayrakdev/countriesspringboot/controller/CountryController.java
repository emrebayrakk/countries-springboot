package com.emrebayrakdev.countriesspringboot.controller;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.initalizer.CountryInitializer;
import com.emrebayrakdev.countriesspringboot.mapper.IMapper;
import com.emrebayrakdev.countriesspringboot.services.country.ICountryService;
import com.emrebayrakdev.countriesspringboot.utils.GenericResponse;
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
    private IMapper _mapper;


    @GetMapping("/getAll")
    public GenericResponse<List<Country>> GetAllCountries(){
        var response = _countryService.getAllCountries();
        return GenericResponse.<List<Country>>builder().
               success(true).
               data(response).build();
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
    public GenericResponse<GetCountryDto> insertCountry(@RequestBody CreateCountryDto entity){
        Country mappedCountry = _mapper.toCountry(entity);
        Country country = _countryService.createCounty(mappedCountry);
        var response = _mapper.fromGetCountry(country);
        return GenericResponse.<GetCountryDto>builder()
                .success(true)
                .data(response).build();
    }



}
