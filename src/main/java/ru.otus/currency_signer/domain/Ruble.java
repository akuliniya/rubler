package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public class Ruble implements Currency {
    private final String currencyName = "Рубль";
    private final int currencyGenderMajor = GenderImpl.MALE.getValue();
    private final int currencyGenderMinor = GenderImpl.FEMALE.getValue();
    private final ArrayList<PriceDegrees> RUBLE_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMajorForms_RU.ONE,
            CurrencyMajorForms_RU.FROM_2_TO_4,
            CurrencyMajorForms_RU.MORE));
    private final ArrayList<PriceDegrees> KOP_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMinorForms_RU.ONE,
            CurrencyMinorForms_RU.FROM_2_TO_4,
            CurrencyMinorForms_RU.MORE));
    Dictionary dictionary = new CurrencyWordFormsDictionaryImpl_RUR();

    @Override
    public int getCurrencyGenderMajor() {
        return currencyGenderMajor;
    }

    @Override
    public int getCurrencyGenderMinor() {
        return currencyGenderMinor;
    }

    @Override
    public ArrayList<PriceDegrees> getCurrencyMajorForms() {
        return RUBLE_FORMS;
    }

    @Override
    public ArrayList<PriceDegrees> getCurrencyMinorForms() {
        return KOP_FORMS;
    }

    @Override
    public Dictionary getDictionary() {
        return dictionary;
    }

    @Override
    public String getName() {
        return currencyName;
    }


}
