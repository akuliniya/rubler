package ru.otus.currency_signer.api.services;

import ru.otus.currency_signer.exceptions.NotANumberException;

import java.util.ArrayList;
import java.util.List;

public interface SplitService {
    List<String> splitOnSubLevels(String s) throws NotANumberException;
}
