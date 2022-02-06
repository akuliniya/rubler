package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum ThousandsPostfix implements LevelsInPrice {
    ONE_THOUSAND,
    FROM_2_TO_4_THOUSAND,
    MORE_THOUSAND,
    ;

    private static final int THOUSANDS_GENDER = Gender.FEMALE.getValue();
    private static final ArrayList<LevelsInPrice> THOUSANDS_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_THOUSAND, FROM_2_TO_4_THOUSAND, MORE_THOUSAND));

    public static int getThousandsGender(){
        return THOUSANDS_GENDER;
    }
    public static ArrayList<LevelsInPrice> getThousands(){
        return THOUSANDS_POSTFIX;
    }


    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
};
