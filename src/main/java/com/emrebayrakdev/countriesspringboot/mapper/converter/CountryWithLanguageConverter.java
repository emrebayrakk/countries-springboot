package com.emrebayrakdev.countriesspringboot.mapper.converter;

import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCustomCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.entities.Language;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CountryWithLanguageConverter {
    public List<GetCustomCountryDto> toDto(List<Country> countries) {
        List<GetCustomCountryDto> getCountryDtos = new ArrayList<>();
        for (Country dto : countries){
            GetCustomCountryDto data = new GetCustomCountryDto();
            data.setId(dto.getId());
            data.setName(dto.getName());
            data.setNativeName(dto.getNativeName());
            List<String> lang = new ArrayList<>();
            for (Language language : dto.getLanguages()){
                lang.add(language.getName());
            }
            data.setLanguages(lang);
            getCountryDtos.add(data);
        }
        return getCountryDtos;
    }
}
