package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.currency_signer.api.services.IOService;
import ru.otus.currency_signer.services.ConsoleIOService;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleIOServiceTest {
    private static final String EOL = System.lineSeparator();
    private static final String TEXT_TO_PRINT = "Строка 123";
    private static final String TEXT_TO_PRINT_ERR = "Строка с ошибкой 123";
    private static final String TEXT_TO_READ = "Строка 987654321";

    private PrintStream backup;
    private ByteArrayOutputStream bos;
    private ByteArrayInputStream bis;
    private IOService ioService;

    @BeforeEach
    void setUp() {
        backup = System.out;
        bos = new ByteArrayOutputStream();
        bis = new ByteArrayInputStream(TEXT_TO_READ.getBytes());
        System.setOut(new PrintStream(bos));
        System.setErr(new PrintStream(bos));
        System.setIn(bis);
        ioService = new ConsoleIOService();
    }

    @AfterEach
    void tearDown() {
        System.setOut(backup);
    }

    @Test
    void outputStrTest() {
        ioService.outputStr(TEXT_TO_PRINT);
        assertEquals((TEXT_TO_PRINT + EOL), bos.toString());
    }

    @Test
    void outputErrTest() {
        ioService.outputErr(TEXT_TO_PRINT_ERR);
        assertEquals((TEXT_TO_PRINT_ERR + EOL), bos.toString());
    }

    @Test
    void outputStrWithTemplateTest() {
        String template = "%s%.2f%.2f";
        String expected = TEXT_TO_PRINT + "2000.00" + "5000.00" + EOL;
        ioService.outputStr(template, TEXT_TO_PRINT, 2000.000, 5000.000);
        assertEquals(expected, bos.toString());
    }

    @Test
    void readStringTest() {
        String actual = ioService.readString();
        assertEquals(TEXT_TO_READ, actual);
    }

    @Test
    void readStringWithTemplateTest() {
        outputStrWithTemplateTest();
        readStringTest();
    }
}