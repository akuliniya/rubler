package ru.otus.currency_signer.api.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.exceptions.NumberIsNotInDiapasonException;

public interface ConverterToPrice {
    Price convert(String input, Currency currency) throws NotANumberException, NumberIsNotInDiapasonException;

}
