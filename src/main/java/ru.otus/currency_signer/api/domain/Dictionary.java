package ru.otus.currency_signer.api.domain;

import java.util.Map;

public interface Dictionary {
    Map<Enum, String> getTranslationsList();

}
