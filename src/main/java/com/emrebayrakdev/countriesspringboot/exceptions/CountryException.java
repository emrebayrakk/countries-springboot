package com.emrebayrakdev.countriesspringboot.exceptions;

import com.emrebayrakdev.countriesspringboot.utils.constants.i18n.I18nConstants;

public class CountryException extends AlreadyExistException{
    public CountryException() {
        super(I18nConstants.COUNTRY_ALREADY_EXISTS);
    }
}
