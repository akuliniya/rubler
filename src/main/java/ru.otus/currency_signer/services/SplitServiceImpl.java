package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.exceptions.NotANumberException;

import java.util.ArrayList;
import java.util.List;

public class SplitServiceImpl implements SplitService {
    @Override
    public List<String> splitOnSubLevels(String input) throws  NotANumberException {
        List<String> splitedString = new ArrayList<>();
        int separatorsQuantity = countSeparators(input);
        switch (separatorsQuantity) {
            case 0 -> {
                splitedString.add(input);
                splitedString.add("");
            }
            case 1 -> {
                String[] inputValue = input.split("\\.");
                splitedString.add(inputValue[0]);
                splitedString.add(inputValue[1]);
            }
            default -> throw new NotANumberException();
        }
        return splitedString;
    }

    private static int countSeparators(String input) {
        long count = input.chars().filter(ch -> ch == '.').count();
        return (int) count;
    }
}
