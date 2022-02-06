package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public enum BillionsPostfix implements LevelsInPrice {
    ONE_BILLION,
    FROM_2_TO_4_BILLION,
    MORE_BILLION,
    ;

    private static final int BILLIONS_GENDER = Gender.MALE.getValue();
    private static final ArrayList<LevelsInPrice> BILLION_POSTFIX = new ArrayList<>(Arrays.asList(
            ONE_BILLION, FROM_2_TO_4_BILLION, MORE_BILLION));

    public static int getBillionsGender(){
        return BILLIONS_GENDER;
    }
    public static ArrayList<LevelsInPrice> getBillions() {
        return BILLION_POSTFIX;
    }

    @Override
    public String toString(Currency currency) {
        return currency.getDictionary().getTranslationsList().get(this);
    }

};
