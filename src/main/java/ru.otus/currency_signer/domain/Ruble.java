package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.LevelsInPrice;

import java.util.ArrayList;
import java.util.Arrays;

public class Ruble implements Currency {
    private final String currencyName = "Рубль";
    private final int currencyGenderMajor = Gender.MALE.getValue();
    private final int currencyGenderMinor = Gender.FEMALE.getValue();
    private final ArrayList<LevelsInPrice> RUBLE_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMajorForms_RU.ONE,
            CurrencyMajorForms_RU.FROM_2_TO_4,
            CurrencyMajorForms_RU.MORE));
    private final ArrayList<LevelsInPrice> KOP_FORMS = new ArrayList<>(Arrays.asList(
            CurrencyMinorForms_RU.ONE,
            CurrencyMinorForms_RU.FROM_2_TO_4,
            CurrencyMinorForms_RU.MORE));
    Dictionary dictionary = new CurrencyDictionaryImpl_RUR();

    @Override
    public int getCurrencyGenderMajor() {
        return currencyGenderMajor;
    }

    @Override
    public int getCurrencyGenderMinor() {
        return currencyGenderMinor;
    }

    @Override
    public ArrayList<LevelsInPrice> getCurrencyMajorForms() {
        return RUBLE_FORMS;
    }

    @Override
    public ArrayList<LevelsInPrice> getCurrencyMinorForms() {
        return KOP_FORMS;
    }

    @Override
    public Dictionary getDictionary() {
        return dictionary;
    }




}
