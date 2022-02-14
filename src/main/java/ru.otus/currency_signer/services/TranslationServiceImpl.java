package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.PriceDegrees;
import ru.otus.currency_signer.api.services.TranslationService;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.domain.Units;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.otus.currency_signer.domain.BillionsPostfix.getBillions;
import static ru.otus.currency_signer.domain.BillionsPostfix.getBillionsGender;
import static ru.otus.currency_signer.domain.Hundreds.getHundreds;
import static ru.otus.currency_signer.domain.MillionsPostfix.getMillions;
import static ru.otus.currency_signer.domain.MillionsPostfix.getMillionsGender;
import static ru.otus.currency_signer.domain.Price.MAIN_CURRENCY_LEVEL;
import static ru.otus.currency_signer.domain.Price.SUB_CURRENCY_LEVEL;
import static ru.otus.currency_signer.domain.Tens.getTens;
import static ru.otus.currency_signer.domain.ThousandsPostfix.getThousands;
import static ru.otus.currency_signer.domain.ThousandsPostfix.getThousandsGender;
import static ru.otus.currency_signer.domain.TrillionsPostfix.getTrillions;
import static ru.otus.currency_signer.domain.TrillionsPostfix.getTrillionsGender;
import static ru.otus.currency_signer.domain.Units.*;

public class TranslationServiceImpl implements TranslationService {
    Dictionary dictionary;

    public TranslationServiceImpl(Dictionary dictionaryOfNumbers){
        this.dictionary = dictionaryOfNumbers;
    }

    @Override
    public String translateNumericToString(Price price) {
        List<PriceDegrees> words = new ArrayList<>();
        Currency currency = price.getCurrency();
        String translation = "";

        Dictionary currencyWordFormsDictionary = price.getCurrency().getDictionary();
        Map<Enum, String> currencyTranslations = currencyWordFormsDictionary.getTranslationsList();
        dictionary.getTranslationsList().putAll(currencyTranslations);

        int mainPrice = price.getPriceSubLevels().get(0);
        int subPrice = price.getPriceSubLevels().get(1);
        words.addAll(convertNumericToWords(mainPrice, MAIN_CURRENCY_LEVEL, currency));
        if (subPrice >= 0) {
            words.addAll(convertNumericToWords(subPrice, SUB_CURRENCY_LEVEL, currency));
        }

        for (PriceDegrees word : words) {
            translation += dictionary.getTranslationsList().get(word) + " ";
        }
        return translation;
    }

    private List<PriceDegrees> convertNumericToWords(int numberForConvertation, int level, Currency currency) {
        List<PriceDegrees> words = new ArrayList<>();
        if (numberForConvertation == 0) {
            words.add(Units.ZERO);
        }
        int gender = findGender(level, currency);
        int segment = numberForConvertation % 1000;

        int hundreds = segment / 100;
        if (hundreds > 0) words.add(getHundreds().get(hundreds - 1));

        segment = segment % 100;
        int tens = segment / 10;
        int units = segment % 10;
        switch (tens) {
            case 0 -> {
            }
            case 1 -> words.add(getFirstTen().get(units));
            default -> words.add(getTens().get(tens - 2));
        }

        if (tens == 1) {
            units = 0;
        }

        switch (units) {
            case 0 -> { }
            case 1, 2 -> {
                switch (gender) {
                    case 1 -> words.add(getMaleUnits().get(units - 1));
                    default -> words.add(getFemaleUnits().get(units - 1));
                }
            }
            default -> words.add(getMaleUnits().get(units - 1));
        }

        words.add(setLevelName(units, segment, level, currency));

        int nextNum = numberForConvertation / 1000;
        if (nextNum > 0) {
            words.addAll(0, convertNumericToWords(nextNum, level + 1, currency));
        }
        return words;
    }

    private PriceDegrees setLevelName(int unit, int segment, int level, Currency currency) {
        switch (unit) {
            case 1 -> {
                return chooseFormInLevel(level, 0, currency);
            }
            case 2, 3, 4 -> {
                return chooseFormInLevel(level, 1, currency);
            }
            default -> {
                if (segment != 0|| level == 1 || level == 0)  //если трехзначный сегмент = 0, то добавлять нужно только "рублей"
                    return chooseFormInLevel(level, 2, currency);
            }
        }
        return null;
    }

    private int findGender(int level, Currency currency) {
        switch (level) {
            case 0 -> { return currency.getCurrencyGenderMinor();
            }
            case 1 -> { return currency.getCurrencyGenderMajor();
            }
            case 2 -> { return getThousandsGender();
            }
            case 3 -> { return getMillionsGender();
            }
            case 4 -> { return getBillionsGender();
            }
            case 5 -> { return getTrillionsGender();
            }
            default -> { return 1;
            }
        }
    }

    private PriceDegrees chooseFormInLevel(int level, int index, Currency currency) {
        switch (level) {
            case 0 -> { return currency.getCurrencyMinorForms().get(index);
            }
            case 1 -> { return currency.getCurrencyMajorForms().get(index);
            }
            case 2 -> { return getThousands().get(index);
            }
            case 3 -> { return getMillions().get(index);
            }
            case 4 -> { return getBillions().get(index);
            }
            case 5 -> { return getTrillions().get(index);
            }
            default -> { return null;
            }
        }
    }
}
