package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.otus.currency_signer.api.services.SplitService;
import ru.otus.currency_signer.exceptions.NotANumberException;
import ru.otus.currency_signer.services.SplitServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitServiceImplTest {
    private static final String SPLITTER = ".";
    private SplitService splitService;
    private String input;
    private List<String> expected;
    private List<String> actual;

    @BeforeEach
    void setUp() {
        splitService = new SplitServiceImpl();
        expected = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{index} - {0} splitPriceOnSubLevelZeroSplitterTest")
    @ValueSource(strings = {"0", "1", "10", "01", "123456789", "1000000000", "0456", "00001000000000"})
    void splitPriceOnSubLevelZeroSplitterTest(String input) {
        expected.add(input);
        expected.add("");
        System.out.println(input);
        try {
            actual = splitService.splitOnSubLevels(input);
            assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (NotANumberException e) {
        }
    }

    @ParameterizedTest(name = "{index} - {0} {1} splitPriceOnSubLevelsOneSplitterTest")
    @CsvSource({
            "123456789, 9",
            "0, 0",
            "0, 01",
            "999999999, 999"
    })
    void splitPriceOnSubLevelsOneSplitterTest(String firstPart, String secondPart) {
        expected.add(firstPart);
        expected.add(secondPart);
        input = firstPart + SPLITTER + secondPart;
        System.out.println(input);
        try {
            actual = splitService.splitOnSubLevels(input);
            assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (NotANumberException e) {
        }

    }

    @ParameterizedTest(name = "{index} - {0} {1} splitPriceOnSubLevelsDefaultSplitterTest")
    @CsvSource({
            "123456789, 9, 5",
            "0, 0, 0",
    })
    void splitPriceOnSubLevelsDefaultSplitterTest(String firstPart, String secondPart, String thirdPart) {
        input = firstPart + SPLITTER + secondPart + SPLITTER + thirdPart;
        System.out.println(input);
        Throwable thrown = assertThrows(NotANumberException.class, () -> {
            actual = splitService.splitOnSubLevels(input);
        });
        assertNotNull(thrown.getMessage());
    }

}