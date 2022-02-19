package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.services.ConverterToPrice;
import ru.otus.currency_signer.api.services.IOService;
import ru.otus.currency_signer.api.services.TranslationService;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.domain.Ruble;
import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.exceptions.NumberIsNotInDiapasonException;

import static ru.otus.currency_signer.services.CheckDiapasonServiceImpl.MAX_VALUE;
import static ru.otus.currency_signer.services.CheckDiapasonServiceImpl.MIN_VALUE;

public class AppRunner {
    private final IOService ioService;
    private final ConverterToPrice converterToPrice;
    private final TranslationService translationService;

    public AppRunner(IOService ioService,
                     ConverterToPrice conversionService,
                     TranslationService translationService) {
        this.ioService = ioService;
        this.converterToPrice = conversionService;
        this.translationService = translationService;
    }

    public void run() {
        Currency currency = new Ruble();
        Price price;

        ioService.outputStr("Ввведите чило в диапазоне от %.2f до %.2f (два знака после запятой, разделитель \".\").%n" +
                            "Для подтверждения ввода нажмите Enter", MIN_VALUE, MAX_VALUE);
        String input = ioService.readString();
        try {
            price = converterToPrice.convert(input, currency);
            ioService.outputStr(translationService.translateNumericToString(price));
        }catch (NotANumberException | NumberIsNotInDiapasonException e){
            ioService.outputErr(e.getMessage());
        }catch (NumberFormatException e){
            Throwable throwable = new NotANumberException(e);
            ioService.outputErr(throwable.getMessage());
        }

    }
}
