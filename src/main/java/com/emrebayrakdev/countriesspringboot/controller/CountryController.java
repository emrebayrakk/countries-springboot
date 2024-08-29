package com.emrebayrakdev.countriesspringboot.controller;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.initalizer.CountryInitializer;
import com.emrebayrakdev.countriesspringboot.mapper.IMapper;
import com.emrebayrakdev.countriesspringboot.services.country.ICountryService;
import com.emrebayrakdev.countriesspringboot.services.i18n.II18nMessageService;
import com.emrebayrakdev.countriesspringboot.utils.GenericResponse;
import com.emrebayrakdev.countriesspringboot.utils.constants.Api;
import com.emrebayrakdev.countriesspringboot.utils.constants.i18n.I18nConstants;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Api.CountryConstants.baseUrl)
@AllArgsConstructor
public class CountryController {

    private final ICountryService _countryService;
    private IMapper _mapper;
    private final II18nMessageService _messageService;


    @GetMapping("/getAll")
    public GenericResponse<List<GetCountryDto>> GetAllCountries(){
        var countryList = _countryService.getAllCountries();
        List<GetCountryDto> response = _mapper.fromGetAllCountry(countryList);
        String message = _messageService.getMessage(I18nConstants.COUNTRY_SUCCESSFUL, LocaleContextHolder.getLocale());
        return GenericResponse.<List<GetCountryDto>>builder().
               success(true).message(message).
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
        String message = _messageService.getMessage(I18nConstants.COUNTRY_SUCCESSFUL, LocaleContextHolder.getLocale());
        return GenericResponse.<GetCountryDto>builder()
                .success(true).message(message)
                .data(response).build();
    }



}
