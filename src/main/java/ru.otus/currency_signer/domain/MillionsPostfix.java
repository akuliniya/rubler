package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum MillionsPostfix implements LevelsInPrice {
    ONE_MILLION,
    FROM_2_TO_4_MILLION,
    MORE_MILLION,
    ;

    private static final int MILLIONS_GENDER = Gender.MALE.getValue();
    private static final ArrayList<LevelsInPrice> MILLION_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_MILLION, FROM_2_TO_4_MILLION, MORE_MILLION));

    public static int getMillionsGender(){
        return MILLIONS_GENDER;
    }
    public static ArrayList<LevelsInPrice> getMillions() {
        return MILLION_POSTFIX;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }

};
