package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public enum Units implements PriceDegrees {
    ZERO,
    ONE_MALE,
    TWO_MALE,
    ONE_FEMALE,
    TWO_FEMALE,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,

    TEN,
    ELEVEN,
    TWELVE,
    THIRTEEN,
    FOURTEEN,
    FIFTEEN,
    SIXTEEN,
    SEVENTEEN,
    EIGHTEEN,
    NINETEEN;

    private static final ArrayList<PriceDegrees> UNITS_LIST_MALE = new ArrayList<>(Arrays.asList(
            ONE_MALE, TWO_MALE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE));
    private static final ArrayList<PriceDegrees> UNITS_LIST_FEMALE = new ArrayList<>(Arrays.asList(
            ONE_FEMALE, TWO_FEMALE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE));
    private static final ArrayList<PriceDegrees> FIRST_TEN = new ArrayList<>(Arrays.asList(
            TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN,EIGHTEEN, NINETEEN));

    public static ArrayList<PriceDegrees> getMaleUnits(){
        return UNITS_LIST_MALE;
    }
    public static ArrayList<PriceDegrees> getFemaleUnits(){
        return UNITS_LIST_FEMALE;
    }
    public static ArrayList<PriceDegrees> getFirstTen(){
        return FIRST_TEN;
    }


    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
}
