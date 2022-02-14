package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public class Yena implements Currency {
    private final String currencyName = "Йена";
    private final int currencyGenderMajor = GenderImpl.FEMALE.getValue();
    private final int currencyGenderMinor = GenderImpl.MALE.getValue();
    private final ArrayList<PriceDegrees>  YENA_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMajorForms_RU.ONE,
            CurrencyMajorForms_RU.FROM_2_TO_4,
            CurrencyMajorForms_RU.MORE));
    private final ArrayList<PriceDegrees> CEN_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMinorForms_RU.ONE,
            CurrencyMinorForms_RU.FROM_2_TO_4,
            CurrencyMinorForms_RU.MORE));
    Dictionary dictionary = new CurrencyWordFormsDictionaryImpl_JPY();

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
        return YENA_FORMS;
    }

    @Override
    public ArrayList<PriceDegrees> getCurrencyMinorForms() {
        return CEN_FORMS;
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
