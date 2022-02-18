package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.services.CheckDiapasonService;
import ru.otus.currency_signer.api.services.ConverterToPrice;
import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.api.services.TranslationService;
import ru.otus.currency_signer.domain.DictionaryOfNumbersImpl_RU;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.domain.Ruble;
import ru.otus.currency_signer.services.CheckDiapasonServiceImpl;
import ru.otus.currency_signer.services.TranslationServiceImpl;
import ru.otus.tests.unit.fakes.CurrencySpy;
import ru.otus.tests.unit.fakes.PriceSpy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TranslationServiceImplTest {
    private Currency currency;
    private List<Integer> priceSubLevels;
    private Dictionary dictionaryOfNumbers;
    private TranslationService translator;
    private Price price;
    int count = 0;
    private final List<String> expectedIntsList = Arrays.asList("ноль рублей ", "один рубль ", "два рубля ", "три рубля ",
            "четыре рубля ", "пять рублей ", "шесть рублей ", "семь рублей ", "восемь рублей ", "девять рублей ", "десять рублей ",
            "одиннадцать рублей ", "двенадцать рублей ", "тринадцать рублей ", "четырнадцать рублей ", "пятнадцать рублей ",
            "шестнадцать рублей ", "семнадцать рублей ", "восемнадцать рублей ", "девятнадцать рублей ", "двадцать рублей ",
            "тридцать восемь рублей ", "сорок один рубль ", "пятьдесят два рубля ", "шестьдесят семь рублей ",
            "семьдесят восемь рублей ", "восемьдесят шесть рублей ", "девяносто девять рублей ", "сто рублей ", "двести два рубля ",
            "триста одиннадцать рублей ", "четыреста двадцать восемь рублей ", "пятьсот один рубль ", "шестьсот рублей ",
            "семьсот тридцать четыре рубля ", "восемьсот двадцать один рубль ", "девятьсот девяносто шесть рублей ",
            "одна тысяча рублей ", "двадцать тысяч рублей ", "десять тысяч пятьсот шестьдесят три рубля ",
            "восемнадцать тысяч девятьсот сорок семь рублей ", "сто тысяч рублей ", "один миллион рулей ",
            "девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один рубль ",
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей ",
            "щдин миллиард рублей");
    private final List<String> expectedDoublesList = Arrays.asList();

    @BeforeEach
    void setUp() {
        dictionaryOfNumbers = new DictionaryOfNumbersImpl_RU();
        translator = new TranslationServiceImpl(dictionaryOfNumbers);
        currency = new Ruble();
        priceSubLevels = new ArrayList<>();
        count++;
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{index} - {1} translateNumericToStringUnitsTest")
    @CsvSource({
            "0, 0", "1, 1", "2, 2","3, 3", "4, 4", "5, 5", "6, 6", "7, 7", "8, 8", "9, 9",
            "10 , 10", "11, 11", "12 ,12", "13, 13", "14, 14", "15, 15", "16, 16", "17, 17", "18, 18", "19, 19", "20, 20",
            "21, 38", "22, 41", "23, 52", "24, 67", "25, 78", "26, 86", "27, 99", "28, 100",
            "29, 202", "30, 311", "31, 428", "32, 501", "33, 600", "34, 734", "35, 821", "36, 996", "37, 1000",
            "38, 20000", "39, 10563", "40, 18947", "41, 100000", "42, 1000000", "43, 987654321", "44, 123456789", "45, 1000000000"})
    void translateNumericToStringUnitsTest(int index, Integer mainCurrency) {
        price = new Price(priceSubLevels, currency);
        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(-1);
        String actual = translator.translateNumericToString(price);
        assertEquals(expectedIntsList.get(index), actual);
    }

    @Test
    void translateNumericToStringTensTest() {
    }

    @Test
    void translateNumericToStringFirstTenTest() {
    }

    @Test
    void translateNumericToStringHundredsTest() {
    }

    @Test
    void translateNumericToStringThousandsTest() {
    }

    @Test
    void translateNumericToStringMillionsTest() {
    }

    @Test
    void translateNumericToStringSubCurrencyUnitsTest() {
    }

    @Test
    void translateNumericToStringSubCurrencyTensTest() {
    }

    @Test
    void translateNumericToStringSubCurrencyFirstTenTest() {
    }

    @Test
    void translateNumericToStringSubCurrencyHundredsTest() {
    }

    @Test
    void translateNumericToStringZeroTest() {
    }

    @Test
    void translateNumericToStringSubCurrencyZeroTest1() {
    }

    @Test
    void translateNumericToStringSubCurrencyZeroTest2() {
    }

    @Test
    void translateNumericToStringMaxValueTest() {
    }

    @Test
    void translateNumericToStringNotANumberTest() {
    }

    @Test
    void translateNumericToStringNotInDiapasonTest() {
    }
}