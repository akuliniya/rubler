package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class NumbersDictionaryImpl_RU implements Dictionary {
    private static final Map<Enum, String> TRANSLATIONS_LIST = new HashMap<>();

    public NumbersDictionaryImpl_RU() {
        TRANSLATIONS_LIST.put(Units.ZERO, "ноль");
        TRANSLATIONS_LIST.put(Units.ONE_MALE, "один");
        TRANSLATIONS_LIST.put(Units.ONE_FEMALE, "одна");
        TRANSLATIONS_LIST.put(Units.TWO_MALE, "два");
        TRANSLATIONS_LIST.put(Units.TWO_FEMALE, "две");
        TRANSLATIONS_LIST.put(Units.THREE, "три");
        TRANSLATIONS_LIST.put(Units.FOUR, "четыре");
        TRANSLATIONS_LIST.put(Units.FIVE, "пять");
        TRANSLATIONS_LIST.put(Units.SIX, "шесть");
        TRANSLATIONS_LIST.put(Units.SEVEN, "семь");
        TRANSLATIONS_LIST.put(Units.EIGHT, "восемь");
        TRANSLATIONS_LIST.put(Units.NINE, "девять");

        TRANSLATIONS_LIST.put(Units.TEN, "десять");
        TRANSLATIONS_LIST.put(Units.ELEVEN, "одиннадцать");
        TRANSLATIONS_LIST.put(Units.TWELVE,"двенадцать");
        TRANSLATIONS_LIST.put(Units.THIRTEEN, "тринадцать");
        TRANSLATIONS_LIST.put(Units.FOURTEEN, "четырнадцать");
        TRANSLATIONS_LIST.put(Units.FIFTEEN, "пятнадцать");
        TRANSLATIONS_LIST.put(Units.SIXTEEN, "шестнадцать");
        TRANSLATIONS_LIST.put(Units.SEVENTEEN, "семнадцать");
        TRANSLATIONS_LIST.put(Units.EIGHTEEN, "восемнадцать");
        TRANSLATIONS_LIST.put(Units.NINETEEN, "девятнадцать");

        TRANSLATIONS_LIST.put(Tens.TWENTY, "двадцать");
        TRANSLATIONS_LIST.put(Tens.THIRTY, "тридцать");
        TRANSLATIONS_LIST.put(Tens.FORTY, "сорок");
        TRANSLATIONS_LIST.put(Tens.FIFTY, "пятьдесят");
        TRANSLATIONS_LIST.put(Tens.SIXTY, "шестьдесят");
        TRANSLATIONS_LIST.put(Tens.SEVENTY, "семьдесят");
        TRANSLATIONS_LIST.put(Tens.EIGHTY, "восемьдесят");
        TRANSLATIONS_LIST.put(Tens.NINETY, "девяносто");

        TRANSLATIONS_LIST.put(Hundreds.ONE_HUNDRED, "сто");
        TRANSLATIONS_LIST.put(Hundreds.TWO_HUNDRED, "двести");
        TRANSLATIONS_LIST.put(Hundreds.THREE_HUNDRED, "триста");
        TRANSLATIONS_LIST.put(Hundreds.FOUR_HUNDRED, "четыреста");
        TRANSLATIONS_LIST.put(Hundreds.FIVE_HUNDRED, "пятьсот");
        TRANSLATIONS_LIST.put(Hundreds.SIX_HUNDRED, "шестьсот");
        TRANSLATIONS_LIST.put(Hundreds.SEVEN_HUNDRED, "семьсот");
        TRANSLATIONS_LIST.put(Hundreds.EIGHT_HUNDRED, "восемьсот");
        TRANSLATIONS_LIST.put(Hundreds.NINE_HUNDRED, "девятьсот");

        TRANSLATIONS_LIST.put(ThousandsPostfix.ONE_THOUSAND, "тысяча");
        TRANSLATIONS_LIST.put(ThousandsPostfix.FROM_2_TO_4_THOUSAND, "тысячи");
        TRANSLATIONS_LIST.put(ThousandsPostfix.MORE_THOUSAND, "тысяч");

        TRANSLATIONS_LIST.put(MillionsPostfix.ONE_MILLION, "миллион");
        TRANSLATIONS_LIST.put(MillionsPostfix.FROM_2_TO_4_MILLION, "миллиона");
        TRANSLATIONS_LIST.put(MillionsPostfix.MORE_MILLION, "миллионов");

        TRANSLATIONS_LIST.put(BillionsPostfix.ONE_BILLION, "миллиард");
        TRANSLATIONS_LIST.put(BillionsPostfix.FROM_2_TO_4_BILLION, "миллиарда");
        TRANSLATIONS_LIST.put(BillionsPostfix.MORE_BILLION, "миллиардов");

        TRANSLATIONS_LIST.put(TrillionsPostfix.ONE_TRILLION, "триллион");
        TRANSLATIONS_LIST.put(TrillionsPostfix.FROM_2_TO_4_TRILLION, "триллиона");
        TRANSLATIONS_LIST.put(TrillionsPostfix.MORE_TRILLION, "тиллионов");


    }

    @Override
    public Map<Enum, String> getTranslationsList() {
        return TRANSLATIONS_LIST;
    }
}
