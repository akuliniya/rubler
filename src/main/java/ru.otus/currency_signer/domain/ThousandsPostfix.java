package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public enum ThousandsPostfix implements PriceDegrees {
    ONE_THOUSAND,
    FROM_2_TO_4_THOUSAND,
    MORE_THOUSAND,
    ;

    private static final int THOUSANDS_GENDER = GenderImpl.FEMALE.getValue();
    private static final ArrayList<PriceDegrees> THOUSANDS_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_THOUSAND, FROM_2_TO_4_THOUSAND, MORE_THOUSAND));

    public static int getThousandsGender(){
        return THOUSANDS_GENDER;
    }
    public static ArrayList<PriceDegrees> getThousands(){
        return THOUSANDS_POSTFIX;
    }


    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
};
