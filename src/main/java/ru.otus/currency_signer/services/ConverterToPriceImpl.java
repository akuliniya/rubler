package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.services.CheckDiapasonService;
import ru.otus.currency_signer.api.services.ConverterToPrice;
import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.exceptions.NumberIsNotInDiapasonException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConverterToPriceImpl implements ConverterToPrice {
    SplitService splitService;
    CheckDiapasonService checkDiapasonService;

    public ConverterToPriceImpl(SplitService splitService, CheckDiapasonService checkDiapasonService) {
        this.splitService = splitService;
        this.checkDiapasonService = checkDiapasonService;
    }

    @Override
    public Price convert(String input, Currency currency) throws NotANumberException, NumberIsNotInDiapasonException, NumberFormatException {
        Price price;
        List<Integer> priceSubLevels = new ArrayList<>();
        int mainCurrency = -1;
        int subCurrency = -1;

        if (!isNumeric(input)){
            throw new NotANumberException();
        }

        List<String> subLevelsOfInputNumber = splitService.splitOnSubLevels(input);
        String mainCurrencyStringValue = subLevelsOfInputNumber.get(0);
        String subCurrencyStringValue = subLevelsOfInputNumber.get(1);

        if (isNegativeValue(mainCurrencyStringValue)){
            throw new NumberIsNotInDiapasonException();
        }

        mainCurrency = convertToInt(cutLeadingZero(mainCurrencyStringValue));

        if (!subCurrencyStringValue.equals("")) {
            if (subCurrencyStringValue.length() == 1) {
                subCurrencyStringValue += "0";
            }
            subCurrency = convertToInt(subCurrencyStringValue);
        }

        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(subCurrency);
        price = new Price(priceSubLevels, currency);

        return price;
    }

    private int convertToInt(String input)
            throws NumberIsNotInDiapasonException {
        int number = Integer.parseInt(input);
        if (checkDiapasonService.isInDiapason(number)) {
            return number;
        } else {
            throw new NumberIsNotInDiapasonException();
        }
    }

    private boolean isNumeric(String input) {
        String regex = "(?<!\\d)-?\\d*[.,]?\\d+";
        return Pattern.matches(regex, input);
    }

    private boolean isNegativeValue(String input){
        return (input.startsWith("-") && input.length() > 1);
    }

    private boolean isLeadingZero(String input){
        return (input.startsWith("0") && input.length() > 1);
    }

    private String cutLeadingZero(String input){
        if (isLeadingZero(input)){
            input = input.substring(1);
            return cutLeadingZero(input);
        }
        return input;
    }

//    private long convertToLong(String input, double maxValue, double minValue)
//            throws NumberIsNotInDiapasonException {
//        long number = Long.parseLong(input);
//        if (checkDiapasonService.isInDiapason(number, maxValue, minValue)) {
//            return number;
//        } else {
//            throw new NumberIsNotInDiapasonException();
//        }
//    }
}
