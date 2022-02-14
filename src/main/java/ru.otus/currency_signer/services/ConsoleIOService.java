package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.services.IOService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleIOService implements IOService {
    private static final String WRONG_INPUT_MESSAGE = "Некорректный ввод!";
    private final PrintStream out;
    private final PrintStream err;
    private final BufferedReader in;

    public ConsoleIOService() {
        out = System.out;
        err = System.err;
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void outputStr(String s) {
        out.println(s);
    }

    @Override
    public void outputErr(String s) {
        err.println(s);
    }

    @Override
    public void outputStr(String template, Object... args) {
        out.printf(template + "%n", args);
    }

    @Override
    public String readString() {
        try {
            return in.readLine();
        } catch (Exception e) {
            outputErr(WRONG_INPUT_MESSAGE + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public String readString(String prompt) {
        outputStr(prompt);
        try {
            return readString();
        } catch (Exception e) {
            outputErr(WRONG_INPUT_MESSAGE + " " + e.getMessage());
        }
        return null;
    }

}
