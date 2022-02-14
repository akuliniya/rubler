package ru.otus.tests.unit.fakes;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.PriceDegrees;

import java.util.ArrayList;

public class CurrencySpy implements Currency {
    @Override
    public int getCurrencyGenderMajor() {
        return 0;
    }

    @Override
    public int getCurrencyGenderMinor() {
        return 0;
    }

    @Override
    public ArrayList<PriceDegrees> getCurrencyMajorForms() {
        return null;
    }

    @Override
    public ArrayList<PriceDegrees> getCurrencyMinorForms() {
        return null;
    }

    @Override
    public Dictionary getDictionary() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
