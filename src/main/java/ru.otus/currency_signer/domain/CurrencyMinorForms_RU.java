package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

public enum CurrencyMinorForms_RU implements LevelsInPrice {
    ONE,
    FROM_2_TO_4,
    MORE,
    ;

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
}
