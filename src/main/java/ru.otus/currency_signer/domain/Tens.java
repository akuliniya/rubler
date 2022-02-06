package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum Tens implements LevelsInPrice {
    TWENTY,
    THIRTY,
    FORTY,
    FIFTY,
    SIXTY,
    SEVENTY,
    EIGHTY,
    NINETY;


    private static final ArrayList<LevelsInPrice> TENS = new ArrayList<>(Arrays.asList(
            TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY));

    public static ArrayList<LevelsInPrice> getTens(){
        return TENS;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
}
