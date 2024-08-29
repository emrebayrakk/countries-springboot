package com.emrebayrakdev.countriesspringboot.services.i18n;

import java.util.Locale;

public interface II18nMessageService {
    String getMessage(String code, Locale locale, Object... args);
}
