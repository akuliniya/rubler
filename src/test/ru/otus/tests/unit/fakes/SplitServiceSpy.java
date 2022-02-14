package ru.otus.tests.unit.fakes;

import ru.otus.currency_signer.api.services.SplitService;

import java.util.ArrayList;
import java.util.List;

public class SplitServiceSpy implements SplitService {
    private String mainCurrency;
    private String subCurrency;
    private List<String> subLevelsOfInputNumber;

    public SplitServiceSpy(String sMainCurrency, String sSubCurrency) {
        this.mainCurrency = sMainCurrency;
        this.subCurrency = sSubCurrency;
    }

    public SplitServiceSpy() {
        this.mainCurrency = "";
        this.subCurrency = "";
    }

    @Override
    public List<String> splitOnSubLevels(String s) {
        subLevelsOfInputNumber = new ArrayList<>();
        subLevelsOfInputNumber.add(mainCurrency);
        if (subCurrency.equals("-1")){
            subLevelsOfInputNumber.add("");
        }else {
            subLevelsOfInputNumber.add(subCurrency);
        }

        return subLevelsOfInputNumber;
    }
}
