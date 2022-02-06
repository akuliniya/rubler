package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.domain.Ruble;

public class AppRunner {
    public static void main(String[] args) {
        Currency ruble = new Ruble();
        double enteredPriceValue;
        ConverterToNumber converter = new ConverterToNumber();
        TranslationService translator = new TranslationService();
        ConsoleIOService console = new ConsoleIOService();

        console.outputStr("Ввведите чило в диапазоне от %.2f до %.2f (два знака после запятой)." +
                        "Для подтверждения ввода нажмите Enter", converter.getMinValue(), converter.getMaxValue());
        enteredPriceValue = converter.convert(console.readString());
        console.outputStr(translator.translateNumberToWords(enteredPriceValue, ruble));
    }
}
