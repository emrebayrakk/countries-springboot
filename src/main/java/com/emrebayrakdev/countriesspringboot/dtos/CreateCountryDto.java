package com.emrebayrakdev.countriesspringboot.dtos;

import lombok.*;

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
    private String languages;
    private String flagUrl;
}
