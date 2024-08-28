package com.emrebayrakdev.countriesspringboot.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Country {

    @Id
    private String id;
    private String name;
    private String nativeName;
    private int phone;
    private String capital;
    private String continent;
    private String currency;
    //private List<Language> languages;
}
