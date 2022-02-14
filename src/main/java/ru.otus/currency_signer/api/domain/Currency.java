package ru.otus.currency_signer.api.domain;

import java.util.ArrayList;

public interface Currency {
    int getCurrencyGenderMajor();
    int getCurrencyGenderMinor();
    ArrayList<PriceDegrees> getCurrencyMajorForms();
    ArrayList<PriceDegrees> getCurrencyMinorForms();
    Dictionary getDictionary();
    String getName();


}
