package com.emrebayrakdev.countriesspringboot.initalizer;

import com.emrebayrakdev.countriesspringboot.entities.Country;
import com.emrebayrakdev.countriesspringboot.entities.Language;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CountryInitializer {



    public static List<Country> readCountries() {
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

                countryList.add(country);

            }
        } catch (Exception e) {
            System.out.println("Error reading countries file");
            log.error(e.getMessage());
        }
        return countryList;
    }

    private static String generatedFlagUrl(String id) {
        return "http://aedemirsen.bilgimeclisi.com/country_flags/" + id + ".svg";
    }
}
