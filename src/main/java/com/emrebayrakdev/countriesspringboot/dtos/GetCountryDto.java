package com.emrebayrakdev.countriesspringboot.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryDto {
    private String name;
    private String nativeName;
    private String currency;
}
