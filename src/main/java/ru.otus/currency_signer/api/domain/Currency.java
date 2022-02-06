package ru.otus.currency_signer.api.domain;

import ru.otus.currency_signer.domain.Gender;

import java.util.ArrayList;

public interface Currency {
    int getCurrencyGenderMajor();
    int getCurrencyGenderMinor();
    ArrayList<LevelsInPrice> getCurrencyMajorForms();
    ArrayList<LevelsInPrice> getCurrencyMinorForms();
    Dictionary getDictionary();


}
