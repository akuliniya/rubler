package ru.otus.currency_signer.api.services;

import java.io.IOException;

public interface IOService {
    void outputStr(String s);
    void outputErr(String s);
    void outputStr(String template, Object ...args);
    String readString();
    String readString(String template, Object... args);
}
