package ru.otus.currency_signer.services;

import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.exceptions.NumberIsNotInDiapasonException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterToNumber {
    private final static double MAX_VALUE = 1_000_000_000.99;
    private final static double MIN_VALUE = 0.00;

    public double convert(String input) {
        double number;
        try {
            number = convertToDouble(input, MAX_VALUE, MIN_VALUE);
            return number;
        } catch (NotANumberException e) {
            System.err.println(e.getMessage());
        } catch (NumberIsNotInDiapasonException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    private boolean isInDiapason(double input, double maxValue, double minValue) {
        return input >= minValue && input <= maxValue;
    }

    private double convertToDouble(String input, double maxValue, double minValue)
            throws NotANumberException, NumberIsNotInDiapasonException {
        double number = Double.parseDouble(input);
        if (isInDiapason(number, maxValue, minValue)) {
            return number;
        } else {
            throw new NumberIsNotInDiapasonException();
        }
    }

    private long convertToLong(String input, double maxValue, double minValue)
            throws NotANumberException, NumberIsNotInDiapasonException {
        long number = Long.parseLong(input);
        if (isInDiapason(number, maxValue, minValue)) {
            return number;
        } else {
            throw new NumberIsNotInDiapasonException();
        }
    }

    private int convertToInt(String input, double maxValue, double minValue)
            throws NotANumberException, NumberIsNotInDiapasonException {
        int number = Integer.parseInt(input);
        if (isInDiapason(number, maxValue, minValue)){
            return number;
        }else {
            throw new NumberIsNotInDiapasonException();
        }
    }

    public Object getMaxValue() {
        return MAX_VALUE;
    }

    public Object getMinValue() {
        return MIN_VALUE;
    }
}
