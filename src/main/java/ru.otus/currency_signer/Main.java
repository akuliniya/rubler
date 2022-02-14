package ru.otus.currency_signer;

import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.services.CheckDiapasonService;
import ru.otus.currency_signer.api.services.ConverterToPrice;
import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.api.services.TranslationService;
import ru.otus.currency_signer.domain.DictionaryOfNumbersImpl_RU;
import ru.otus.currency_signer.services.*;

public class Main {
    public static void main(String[] args) {
        ConsoleIOService console = new ConsoleIOService();
        SplitService splitService = new SplitServiceImpl();
        CheckDiapasonService checkDiapasonService = new CheckDiapasonServiceImpl();
        Dictionary dictionaryOfNumbers = new DictionaryOfNumbersImpl_RU();
        ConverterToPrice converter = new ConverterToPriceImpl(splitService, checkDiapasonService);
        TranslationService translator = new TranslationServiceImpl(dictionaryOfNumbers);

        AppRunner appRunner = new AppRunner(console, converter, translator);
        appRunner.run();
    }
}
