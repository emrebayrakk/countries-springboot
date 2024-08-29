package com.emrebayrakdev.countriesspringboot.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    @Column(unique=true)
    private Long id;

    @Column(unique=true)
    private String code;

    private String name;

    private String nativeName;

    private int phone;

    private String capital;

    private String continent;

    private String currency;

    private String languages;

    @Column(unique=true)
    private String flagUrl;
    //private List<Language> languages;
}
