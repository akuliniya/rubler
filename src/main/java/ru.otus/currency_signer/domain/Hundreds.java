package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum Hundreds implements LevelsInPrice {
    ONE_HUNDRED,
    TWO_HUNDRED,
    THREE_HUNDRED,
    FOUR_HUNDRED,
    FIVE_HUNDRED,
    SIX_HUNDRED,
    SEVEN_HUNDRED,
    EIGHT_HUNDRED,
    NINE_HUNDRED,
    ж;

    private static final ArrayList<LevelsInPrice> HUNDREDS = new ArrayList<>(Arrays.asList(
            ONE_HUNDRED, TWO_HUNDRED, THREE_HUNDRED, FOUR_HUNDRED, FIVE_HUNDRED, SIX_HUNDRED, SEVEN_HUNDRED, EIGHT_HUNDRED, NINE_HUNDRED));

    public static ArrayList<LevelsInPrice> getHundreds(){
        return HUNDREDS;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
}
