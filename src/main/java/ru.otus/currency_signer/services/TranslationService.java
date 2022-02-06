package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.domain.LevelsInPrice;
import ru.otus.currency_signer.domain.*;
import java.util.*;

import static ru.otus.currency_signer.domain.BillionsPostfix.*;
import static ru.otus.currency_signer.domain.Hundreds.*;
import static ru.otus.currency_signer.domain.MillionsPostfix.*;
import static ru.otus.currency_signer.domain.Tens.*;
import static ru.otus.currency_signer.domain.ThousandsPostfix.*;
import static ru.otus.currency_signer.domain.TrillionsPostfix.*;
import static ru.otus.currency_signer.domain.Units.*;

public class TranslationService {
    private static final int MAIN_CURRENCY_LEVEL = 1;
    private static final int SUB_CURRENCY_LEVEL = 0;

    public String translateNumberToWords(double inputNumber, Currency currency) {
        String translation = "";
        Dictionary dictionary = new Dictionary() {
            Map<Enum, String> translationList = new HashMap<>();
            @Override
            public Map<Enum, String> getTranslationsList() {
                return translationList;
            }
        };
        dictionary.getTranslationsList().putAll(new NumbersDictionaryImpl_RU().getTranslationsList());
        dictionary.getTranslationsList().putAll(currency.getDictionary().getTranslationsList());
        List<LevelsInPrice> wordsToTranslate = convertDoubleToWords(inputNumber, currency);
        for (LevelsInPrice word : wordsToTranslate){
            translation += dictionary.getTranslationsList().get(word) + " ";
        }
        return translation;
    }

    public List<LevelsInPrice> convertIntegerToWords(int enteredPriceValue, int level, Currency currency) {
        List<LevelsInPrice> words = new ArrayList<>();

        if (enteredPriceValue == 0){
            words.add(Units.ZERO);         //исключительный случай
        }
        int gender = findGender(level, currency);

        int h = enteredPriceValue % 1000;    //текущий трехзначный сегмент
        int d = h / 100;              //цифра сотен
        if (d > 0) words.add(getHundreds().get(d - 1));

        int n = h % 100;
        d = n / 10;                   //цифра десятков
        n = n % 10;                   //цифра единиц
        switch(d) {
            case 0 -> {}
            case 1 -> words.add(getFirstTen().get(n));
            default -> words.add(getTens().get(d - 2));
        }

        if (d == 1){
            n = 0;              //при двузначном остатке от 10 до 19, цифра едициц не должна учитываться
        }

        switch(n) {
            case 0 -> {}
            case 1, 2 -> {
                switch(gender) {
                    case 1 -> words.add(getMaleUnits().get(n - 1));
                    default -> words.add(getFemaleUnits().get(n - 1));
                }
            }
            default -> words.add(getMaleUnits().get(n - 1));
        }

        switch(n) {
            case 1 -> words.add(chooseFormInLevel(level,0, currency));
            case 2, 3, 4 -> words.add(chooseFormInLevel(level,1, currency));
            default -> {
                if((h != 0) || ((h == 0) && (level == 1)))  //если трехзначный сегмент = 0, то добавлять нужно только "рублей"
                    words.add(chooseFormInLevel(level,2, currency));
            }
        }

        int nextNum = enteredPriceValue / 1000;
        if(nextNum > 0) {
            words.addAll(0, convertIntegerToWords(nextNum, level + 1, currency));
            return words;
        } else {
            return words;
        }
    }

    public List<LevelsInPrice> convertDoubleToWords(double enteredPriceValue, Currency currency) {
        List<LevelsInPrice> words = new ArrayList<>();
        int gender = findGender(SUB_CURRENCY_LEVEL, currency);

        String priceInStringFormat = String.format("%.2f", enteredPriceValue);
        String sKopecks = priceInStringFormat.substring(priceInStringFormat.length()-2, priceInStringFormat.length());
        int kopecks = Integer.parseInt(sKopecks);
        int d = kopecks / 10;         //цифра десятков
        int n = kopecks % 10;                   //цифра единиц
        switch(d) {
            case 0 -> {}
            case 1 -> words.add(getFirstTen().get(n));
            default -> words.add(getTens().get(d - 2));
        }

        if (d == 1){
            n = 0;              //при двузначном остатке от 10 до 19, цифра едициц не должна учитываться
        }

        switch(n) {
            case 0 -> {}
            case 1, 2 -> {
                switch(gender) {
                    case 1 -> words.add(getMaleUnits().get(n - 1));
                    default -> words.add(getFemaleUnits().get(n - 1));
                }
            }
            default -> words.add(getMaleUnits().get(n - 1));
        }

        switch(n) {
            case 1 -> words.add(chooseFormInLevel(SUB_CURRENCY_LEVEL,0, currency));
            case 2, 3, 4 -> words.add(chooseFormInLevel(SUB_CURRENCY_LEVEL,1, currency));
            default -> words.add(chooseFormInLevel(SUB_CURRENCY_LEVEL,2, currency));
        }

        int rubles = convertDoubleToInt(enteredPriceValue);
        words.addAll(0, convertIntegerToWords(rubles, MAIN_CURRENCY_LEVEL, currency));
        return words;
    }

    private int findGender(int level, Currency currency) {
        switch(level){
            case 0 -> {return currency.getCurrencyGenderMinor();}
            case 1 -> {return currency.getCurrencyGenderMajor();}
            case 2 -> {return getThousandsGender();}
            case 3 -> {return getMillionsGender();}
            case 4 -> {return getBillionsGender();}
            case 5 -> {return getTrillionsGender();}
            default -> {return 1;}
        }
    }

    private LevelsInPrice chooseFormInLevel(int level, int index, Currency currency) {
        switch(level){
            case 0 -> {return currency.getCurrencyMinorForms().get(index);}
            case 1 -> {return currency.getCurrencyMajorForms().get(index);}
            case 2 -> {return getThousands().get(index);}
            case 3 -> {return getMillions().get(index);}
            case 4 -> {return getBillions().get(index);}
            case 5 -> {return getTrillions().get(index);}
            default -> {return null;}
        }
    }

    private int convertDoubleToInt(double doubleValue) {
        Double doubleValueObject = doubleValue;
        return doubleValueObject.intValue();
    }

    private long convertDoubleToLong(double doubleValue) {
        Double doubleValueObject = doubleValue;
        return doubleValueObject.longValue();
    }
}
