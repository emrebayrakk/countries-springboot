package com.emrebayrakdev.countriesspringboot.exceptions;


import com.emrebayrakdev.countriesspringboot.services.i18n.II18nMessageService;
import com.emrebayrakdev.countriesspringboot.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final II18nMessageService _messageService;

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<GenericResponse<Object>> handleAlreadyExistsException(AlreadyExistException existException){
        String message = _messageService.getMessage(existException.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                GenericResponse.builder()
                        .success(false)
                        .message(message)
                        .data(LocaleContextHolder.getLocale().toString()).build()
        );
    }
}
