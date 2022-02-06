package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class CurrencyDictionaryImpl_RUR implements Dictionary {
    private static final Map<Enum, String> TRANSLATIONS_LIST = new HashMap<>();

    public CurrencyDictionaryImpl_RUR() {
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.ONE, "рубль");
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.FROM_2_TO_4, "рубля");
        TRANSLATIONS_LIST.put(CurrencyMajorForms_RU.MORE, "рублей");

        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.ONE, "копейка");
        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.FROM_2_TO_4, "копейки");
        TRANSLATIONS_LIST.put(CurrencyMinorForms_RU.MORE, "копеек");
    }

    @Override
    public Map<Enum, String> getTranslationsList() {
        return TRANSLATIONS_LIST;
    }
}
