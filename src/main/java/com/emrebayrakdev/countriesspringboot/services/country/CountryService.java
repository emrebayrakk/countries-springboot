package com.emrebayrakdev.countriesspringboot.services.country;

import com.emrebayrakdev.countriesspringboot.dtos.CreateCountryDto;
import com.emrebayrakdev.countriesspringboot.dtos.GetCountryDto;
import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.entities.Language;
import com.emrebayrakdev.countriesspringboot.exceptions.CountryException;
import com.emrebayrakdev.countriesspringboot.initalizer.CountryInitializer;
import com.emrebayrakdev.countriesspringboot.mapper.IMapper;
import com.emrebayrakdev.countriesspringboot.repositories.country.ICountryRepository;
import com.emrebayrakdev.countriesspringboot.repositories.country.ILanguageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

    private final ICountryRepository _countryRepository;
    private final ILanguageRepository _languageRepository;

    /* public CountryService(ICountryRepository countryRepository) {
        _countryRepository = countryRepository;
    }*/
    private IMapper _mapper;

    @Override
    public List<Country> getAllCountries() {
        var response = _countryRepository.findAll();
        return response;
    }

    @Override
    public List<GetCountryDto> getAllCustomMapperCountries() {
        var response = _countryRepository.findAll();
        List<GetCountryDto> dtos = new ArrayList<>();
        for (Country dto : response){
          GetCountryDto data = new GetCountryDto();
          data.setId(dto.getId());
          data.setName(dto.getName());
          data.setNativeName(dto.getNativeName());
          List<String> lang = new ArrayList<>();
          for (Language language : dto.getLanguages()){
              lang.add(language.getName());
          }
          data.setLanguages(lang);
          dtos.add(data);
        }
        return dtos;
    }

    @Override
    public List<Country> insertCountries() {
        return parseAndSaveCountries();
    }

    @Override
    public Country createCounty(Country entity) {
        var country = findByCodeCountry(entity.getCode());
        if (country != null) {
            throw new CountryException();
        }
        else{
            return  _countryRepository.save(entity);
        }
    }

    @Override
    public Country findByCodeCountry(String code) {
        return _countryRepository.findByCode(code).orElse(null);
    }
    public List<Country> parseAndSaveCountries() {
        String root = System.getProperty("user.dir");

        List<Country> countryList = new ArrayList<>();
        try {
            File file = new File(root + "/assets/countries.json");
            Map<String, Map<String, Object>> result = new ObjectMapper().readValue(file, HashMap.class);

            for (String code : result.keySet()) {
                Map<String, Object> valueMap = result.get(code);
                String name = valueMap.get("name").toString();
                String nativeName = valueMap.get("native").toString();
                String continent = valueMap.get("continent").toString();
                String capital = valueMap.get("capital").toString();
                String currency = valueMap.get("currency").toString();
                List<String> languageList = (List<String>) valueMap.get("languages");
                int phone;
                try {
                    phone = Integer.parseInt(valueMap.get("phone").toString());
                } catch (NumberFormatException e) {
                    phone = -1;
                }

                String flagUrl = generatedFlagUrl(code);

                Country country = Country.builder()
                        .code(code)
                        .name(name)
                        .nativeName(nativeName)
                        .continent(continent)
                        .capital(capital)
                        .currency(currency)
                        .phone(phone)
                        .flagUrl(flagUrl)
                        .build();

                List<Language> languages = new ArrayList<>();
                for (String lang : languageList) {
                    Language language = new Language();
                    language.setName(lang);
                    language.setCountry(country);
                    languages.add(language);
                }

                country.setLanguages(languages);
                countryList.add(country);
                _countryRepository.save(country);
                _languageRepository.saveAll(languages);
            }
        } catch (Exception e) {
            System.out.println("Error reading countries file");
        }
        return countryList;
    }

    private static String generatedFlagUrl(String id) {
        return "http://aedemirsen.bilgimeclisi.com/country_flags/" + id + ".svg";
    }
}
