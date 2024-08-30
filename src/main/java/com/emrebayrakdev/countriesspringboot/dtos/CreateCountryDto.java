package com.emrebayrakdev.countriesspringboot.dtos;

import com.emrebayrakdev.countriesspringboot.entities.Language;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCountryDto {
    private String code;
    private String name;
    private String nativeName;
    private int phone;
    private String capital;
    private String continent;
    private String currency;
    private String flagUrl;
    private List<Language> languages;
}
