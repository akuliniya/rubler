package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public enum BillionsPostfix implements PriceDegrees {
    ONE_BILLION,
    FROM_2_TO_4_BILLION,
    MORE_BILLION,
    ;

    private static final int BILLIONS_GENDER = GenderImpl.MALE.getValue();
    private static final ArrayList<PriceDegrees> BILLION_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_BILLION, FROM_2_TO_4_BILLION, MORE_BILLION));

    public static int getBillionsGender(){
        return BILLIONS_GENDER;
    }
    public static ArrayList<PriceDegrees> getBillions() {
        return BILLION_POSTFIX;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }
};
