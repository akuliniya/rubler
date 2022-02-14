package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public enum Tens implements PriceDegrees {
    TWENTY,
    THIRTY,
    FORTY,
    FIFTY,
    SIXTY,
    SEVENTY,
    EIGHTY,
    NINETY;


    private static final ArrayList<PriceDegrees> TENS = new ArrayList<>(Arrays.asList(
            TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY));

    public static ArrayList<PriceDegrees> getTens(){
        return TENS;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
}
