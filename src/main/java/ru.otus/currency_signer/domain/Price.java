package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Currency;

public class Price {
    int sum;
    Currency currency;

    public Price(int sum, Currency currency){
        this.sum = sum;
        this.currency = currency;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getSum() {
        return sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return sum + " " + currency;
    }

}
