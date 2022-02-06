package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class CurrencyDictionaryImpl_JPY implements Dictionary {
    private static final Map<Enum, String> TRANSLATIONS_LIST = new HashMap<>();

    public CurrencyDictionaryImpl_JPY() {
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.ONE, "йена");
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.FROM_2_TO_4, "йены");
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.MORE, "йен");

        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.ONE, "сен");
        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.FROM_2_TO_4, "сен");
        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.MORE, "сен");
    }

    @Override
    public Map<Enum, String> getTranslationsList() {
        return TRANSLATIONS_LIST;
    }
}
