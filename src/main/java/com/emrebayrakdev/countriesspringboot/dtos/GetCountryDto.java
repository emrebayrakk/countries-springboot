package com.emrebayrakdev.countriesspringboot.dtos;

import com.emrebayrakdev.countriesspringboot.entities.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryDto {
    private Long id;
    private String name;
    private String nativeName;
    private String currency;
}
