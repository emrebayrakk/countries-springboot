package com.emrebayrakdev.countriesspringboot.dtos;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomCountryDto {
    private Long id;
    private String name;
    private String nativeName;
    private String currency;
    private List<String> languages;
}
