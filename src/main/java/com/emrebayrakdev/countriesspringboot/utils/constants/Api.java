package com.emrebayrakdev.countriesspringboot.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Api {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CountryConstants{
        public static final String baseUrl = "/country";
        public static final String swaggerUrl = "http://localhost:8080/api/swagger-ui/index.html";
    }

}
