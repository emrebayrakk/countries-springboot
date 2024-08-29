package com.emrebayrakdev.countriesspringboot.utils;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
