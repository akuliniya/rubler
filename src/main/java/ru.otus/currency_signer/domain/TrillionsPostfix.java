package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum TrillionsPostfix implements LevelsInPrice {
    ONE_TRILLION,
    FROM_2_TO_4_TRILLION,
    MORE_TRILLION,
    ;

    private static final int TRILLIONS_GENDER = Gender.MALE.getValue();

    private static final ArrayList<LevelsInPrice> TRILLION_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_TRILLION, FROM_2_TO_4_TRILLION, MORE_TRILLION));

    public static int getTrillionsGender(){
        return TRILLIONS_GENDER;
    }
    public static ArrayList<LevelsInPrice> getTrillions() {
        return TRILLION_POSTFIX;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }

};
