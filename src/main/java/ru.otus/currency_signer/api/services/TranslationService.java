package ru.otus.currency_signer.api.services;

import ru.otus.currency_signer.domain.Price;

public interface TranslationService {
    String translateNumericToString(Price price);
}
