package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.otus.currency_signer.api.domain.Currency;
import ru.otus.currency_signer.api.services.CheckDiapasonService;
import ru.otus.currency_signer.api.services.ConverterToPrice;
import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.domain.Price;
import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.exceptions.NumberIsNotInDiapasonException;
import ru.otus.currency_signer.services.CheckDiapasonServiceImpl;
import ru.otus.currency_signer.services.ConverterToPriceImpl;
import ru.otus.tests.unit.fakes.CurrencySpy;
import ru.otus.tests.unit.fakes.SplitServiceSpy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterToPriceImplTest {
    private static final String SPLITTER = ".";
    private String input;
    private List<Integer> priceSubLevels;
    private Currency currency;
    private ConverterToPrice converter;
    private SplitService splitService;
    private CheckDiapasonService checkDiapason;

    @BeforeEach
    void setUp() {
        priceSubLevels = new ArrayList<>();
        input = "";
        checkDiapason = new CheckDiapasonServiceImpl();
        currency = new CurrencySpy();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{index} - {0} convertIntTest")
    @ValueSource(strings = { "0", "1", "10", "01", "123456789", "1000000000", "0456", "00001000000000"})
    void convertIntTest(String sMainCurrency) {
        int subCurrency = -1;
        input += sMainCurrency;
        priceSubLevels.add(Integer.parseInt(sMainCurrency));
        priceSubLevels.add(subCurrency);

        splitService = new SplitServiceSpy(sMainCurrency, "-1");
        converter = new ConverterToPriceImpl(splitService, checkDiapason);
        try {
            Price price = converter.convert(input, currency);
            Object[] expected = priceSubLevels.toArray();
            Object[] actual = price.getPriceSubLevels().toArray();
            assertArrayEquals(expected, actual);
        }catch (NotANumberException | NumberIsNotInDiapasonException e){
            System.err.println("Тест со значением mainCurrency = " + sMainCurrency + " не прошел по причине: " + e.getMessage());
        }
    }

    @ParameterizedTest(name = "{index} - {0} {1} convertDoubleTest")
    @CsvSource({
            "123456789, 99",
            "0, 0",
            "999, 20",
            "0, 0",
            "0, 01",
            "0, 11",
            "1000000000, 99"
    })
    void convertDoubleTest(String sMainCurrency, String sSubCurrency) {
        int mainCurrency = Integer.parseInt(sMainCurrency);
        int subCurrency = Integer.parseInt(sSubCurrency);
        input += sMainCurrency + SPLITTER + sSubCurrency;
        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(subCurrency);

        splitService = new SplitServiceSpy(sMainCurrency, sSubCurrency);
        converter = new ConverterToPriceImpl(splitService, checkDiapason);
        try {
            Price price = converter.convert(input, currency);
            Object[] expected = priceSubLevels.toArray();
            Object[] actual = price.getPriceSubLevels().toArray();
            assertArrayEquals(expected, actual);
        }catch (NotANumberException | NumberIsNotInDiapasonException e){
            System.err.println("Тест не прошел по причине: " + e.getMessage());
        }
    }

    @ParameterizedTest(name = "{index} - {0} convertIntWrongFormatTest")
    @ValueSource(strings = { "0f", "0b3", "0x2", "4.05E-13", " 1", "1.0O", "1.2.3"})
    void convertIntWrongFormatTest(String sMainCurrency) {
        input += sMainCurrency;

        splitService = new SplitServiceSpy();
        converter = new ConverterToPriceImpl(splitService, checkDiapason);

        Throwable thrown = assertThrows(NotANumberException.class, () -> {
            Price price = converter.convert(input, currency);
        });
        assertNotNull(thrown.getMessage());
        assertEquals("Введено не число", thrown.getMessage());
    }

    @ParameterizedTest(name = "{index} - {0} convertIntNotInDiapasonTest")
    @ValueSource(strings = { "-0", "-1", "-01", "-1000000000", "1000000001", "00001000000001"})
    void convertIntNotInDiapasonTest(String sMainCurrency) {
        int subCurrency = -1;
        input += sMainCurrency;
        priceSubLevels.add(Integer.parseInt(sMainCurrency));
        priceSubLevels.add(subCurrency);

        splitService = new SplitServiceSpy(sMainCurrency, "-1");
        converter = new ConverterToPriceImpl(splitService, checkDiapason);

        Throwable thrown = assertThrows(NumberIsNotInDiapasonException.class, () -> {
            Price price = converter.convert(input, currency);
        });
        assertNotNull(thrown.getMessage());
        assertEquals("Введенное число выходит за границы требуемого диапазона", thrown.getMessage());
    }

    @ParameterizedTest(name = "{index} - {0} {1} convertDoubleNotInDiapasonTest")
    @CsvSource({
            "1000000001, 01",
            "1000000001, 00",
            "-0, 01",
            "-0, 10",
            "-0, 001"
    })
    void convertDoubleNotInDiapasonTest(String sMainCurrency, String sSubCurrency) {
        int mainCurrency = Integer.parseInt(sMainCurrency);
        int subCurrency = Integer.parseInt(sSubCurrency);
        input += sMainCurrency + SPLITTER + sSubCurrency;
        priceSubLevels.add(mainCurrency);
        priceSubLevels.add(subCurrency);

        splitService = new SplitServiceSpy(sMainCurrency, sSubCurrency);
        converter = new ConverterToPriceImpl(splitService, checkDiapason);

        Throwable thrown = assertThrows(NumberIsNotInDiapasonException.class, () -> {
            Price price = converter.convert(input, currency);
        });
        assertNotNull(thrown.getMessage());
        assertEquals("Введенное число выходит за границы требуемого диапазона", thrown.getMessage());
    }
}