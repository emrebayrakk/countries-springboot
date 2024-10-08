package com.emrebayrakdev.countriesspringboot.mapper;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.entities.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {

    Country toCountry(CreateCountryDto countryDto);
    CreateCountryDto fromCreateCountry(Country country);

    Country toGetCountry(GetCountryDto getCountryDto);
    GetCountryDto fromGetCountry(Country country);

    List<Country> toGetAllCountry(List<GetCountryDto> getCountriesDto);
    List<GetCountryDto> fromGetAllCountry(List<Country> countries);

}


