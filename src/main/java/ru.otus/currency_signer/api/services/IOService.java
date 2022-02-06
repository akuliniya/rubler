package ru.otus.currency_signer.api.services;

import java.io.IOException;

public interface IOService {
    void outputStr(String s);
    void outputErr(String s);
    void outputStr(String template, Object ...args);
    String readString() throws IOException;
    String readString(String prompt) throws IOException;
}
