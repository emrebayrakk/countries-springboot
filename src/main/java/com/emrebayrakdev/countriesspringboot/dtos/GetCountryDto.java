package com.emrebayrakdev.countriesspringboot.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryDto {
    @Id
    @GeneratedValue
    @Column(unique=true)
    private Long id;
    private String name;
    private String nativeName;
    private String currency;
}
