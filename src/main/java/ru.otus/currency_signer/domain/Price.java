package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;

import java.util.List;

public class Price {

    public static final int MAIN_CURRENCY_LEVEL = 1;
    public static final int SUB_CURRENCY_LEVEL = 0;

    private Currency currency;
    private List<Integer> priceSubLevels;

    public Price(List<Integer> priceSubLevels, Currency currency){
        this.priceSubLevels = priceSubLevels;
        this.currency = currency;
    }

    public List<Integer> getPriceSubLevels() {
        return priceSubLevels;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        if (priceSubLevels.get(1) != -1){
            return priceSubLevels.get(0) + "." + priceSubLevels.get(1) + " " + currency.getName();
        }else{
            return priceSubLevels.get(0) + " " + currency.getName();
        }
    }

}
