package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.domain.Dictionary;
import ru.otus.currency_signer.api.services.TranslationService;
import ru.otus.currency_signer.domain.DictionaryOfNumbersImpl_RU;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.domain.Ruble;
import ru.otus.currency_signer.services.TranslationServiceImpl;

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
            "восемнадцать тысяч девятьсот сорок семь рублей ", "сто тысяч рублей ", "один миллион рублей ",
            "девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один рубль ",
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей ",
            "один миллиард рублей ");
    private final List<String> expectedDoublesList = Arrays.asList("ноль рублей ноль копеек ", "один рубль одна копейка ",
            "два рубля две копейки ", "три рубля три копейки ", "четыре рубля четыре копейки ", "пять рублей пять копеек ",
            "шесть рублей шесть копеек ", "семь рублей семь копеек ", "восемь рублей восемь копеек ",
            "девять рублей девять копеек ", "десять рублей десять копеек ", "одиннадцать рублей одиннадцать копеек ",
            "двенадцать рублей двенадцать копеек ", "тринадцать рублей тринадцать копеек ",
            "четырнадцать рублей четырнадцать копеек ", "пятнадцать рублей пятнадцать копеек ",
            "шестнадцать рублей шестнадцать копеек ", "семнадцать рублей семнадцать копеек ",
            "восемнадцать рублей восемнадцать копеек ", "девятнадцать рублей девятнадцать копеек ",
            "двадцать рублей двадцать копеек ", "тридцать восемь рублей тридцать восемь копеек ",
            "сорок один рубль сорок одна копейка ", "пятьдесят два рубля пятьдесят две копейки ",
            "шестьдесят семь рублей шестьдесят семь копеек ", "семьдесят восемь рублей семьдесят восемь копеек ",
            "восемьдесят шесть рублей восемьдесят шесть копеек ", "девяносто девять рублей девяносто девять копеек ",
            "сто рублей ноль копеек ",
            "девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один рубль одиннадцать копеек ",
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей девяносто восемь копеек ",
            "один миллиард рублей девяносто девять копеек ");

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

    @ParameterizedTest(name = "{index} - {1} translateNumericToStringIntsTest")
    @CsvSource({
            "0, 0", "1, 1", "2, 2", "3, 3", "4, 4", "5, 5", "6, 6", "7, 7", "8, 8", "9, 9",
            "10 , 10", "11, 11", "12 ,12", "13, 13", "14, 14", "15, 15", "16, 16", "17, 17", "18, 18", "19, 19", "20, 20",
            "21, 38", "22, 41", "23, 52", "24, 67", "25, 78", "26, 86", "27, 99", "28, 100",
            "29, 202", "30, 311", "31, 428", "32, 501", "33, 600", "34, 734", "35, 821", "36, 996", "37, 1000",
            "38, 20000", "39, 10563", "40, 18947", "41, 100000", "42, 1000000", "43, 987654321", "44, 123456789", "45, 1000000000"})
    void translateNumericToStringIntsTest(int index, Integer mainCurrency) {
        price = new Price(priceSubLevels, currency);
        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(-1);
        String actual = translator.translateNumericToString(price);
        assertEquals(expectedIntsList.get(index), actual);
    }

    @ParameterizedTest(name = "{index} - {1} translateNumericToStringDoublesTest")
    @CsvSource({
            "0, 0, 0", "1, 1, 1", "2, 2, 2", "3, 3, 3", "4, 4, 4", "5, 5, 5", "6, 6, 6", "7, 7, 7", "8, 8, 8", "9, 9, 9",
            "10 , 10, 10", "11, 11, 11", "12 ,12, 12", "13, 13, 13", "14, 14, 14", "15, 15, 15", "16, 16, 16", "17, 17, 17",
            "18, 18, 18", "19, 19, 19", "20, 20, 20", "21, 38, 38", "22, 41, 41", "23, 52, 52", "24, 67, 67", "25, 78, 78",
            "26, 86, 86", "27, 99, 99", "28, 100, 00", "29, 987654321, 11", "30, 123456789, 98", "31, 1000000000, 99"})
    void translateNumericToStringDoublesTest(int index, Integer mainCurrency, Integer subCurrency) {
        price = new Price(priceSubLevels, currency);
        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(subCurrency);
        String actual = translator.translateNumericToString(price);
        assertEquals(expectedDoublesList.get(index), actual);
    }
}