package ru.otus.currency_signer.services;

import ru.otus.currency_signer.api.services.CheckDiapasonService;

public class CheckDiapasonServiceImpl implements CheckDiapasonService {
    public static final double MAX_VALUE = 1_000_000_000.99;
    public static final double MIN_VALUE = 0.00;

    @Override
    public boolean isInDiapason(double input) {
        return input >= MIN_VALUE && input <= MAX_VALUE;
    }
}
