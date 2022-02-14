package ru.otus.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.currency_signer.api.services.CheckDiapasonService;
import ru.otus.currency_signer.services.CheckDiapasonServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class CheckDiapasonServiceImplTest {
    private CheckDiapasonService checkDiapason;

    @BeforeEach
    void setUp() {
        checkDiapason = new CheckDiapasonServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isInDiapasonLessThenMaxTest1() {
        assertTrue(checkDiapason.isInDiapason(1000000000.98));
    }

    @Test
    void isInDiapasonLessThenMaxTest2() {
        assertTrue( checkDiapason.isInDiapason(1000000000));
    }

    @Test
    void isInDiapasonEqualsMinTest() {
        assertTrue(checkDiapason.isInDiapason(0));
    }

    @Test
    void isInDiapasonMoreThenMinTest() {
        assertTrue(checkDiapason.isInDiapason(0.01));
    }

    @Test
    void isInDiapasonMoreThenMaxTest() {
        assertFalse(checkDiapason.isInDiapason(1000000001));
    }

    @Test
    void isInDiapasonLessThenMinTest() {
        assertFalse(checkDiapason.isInDiapason(-0.001));
    }
}