package ru.otus.tests.unit.fakes;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.domain.Price;

import java.util.ArrayList;
import java.util.List;

public class PriceSpy extends Price {
    private List<Integer> priceSubLevels = new ArrayList<>();


    public PriceSpy(List<Integer> priceSubLevels, Currency currency) {
        super(priceSubLevels, currency);
    }
}
