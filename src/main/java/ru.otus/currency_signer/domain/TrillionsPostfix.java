package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public enum TrillionsPostfix implements PriceDegrees {
    ONE_TRILLION,
    FROM_2_TO_4_TRILLION,
    MORE_TRILLION,
    ;

    private static final int TRILLIONS_GENDER = GenderImpl.MALE.getValue();

    private static final ArrayList<PriceDegrees> TRILLION_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_TRILLION, FROM_2_TO_4_TRILLION, MORE_TRILLION));

    public static int getTrillionsGender(){
        return TRILLIONS_GENDER;
    }
    public static ArrayList<PriceDegrees> getTrillions() {
        return TRILLION_POSTFIX;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
};
