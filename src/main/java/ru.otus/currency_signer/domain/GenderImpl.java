package ru.otus.currency_signer.domain;

import ru.otus.currency_signer.api.domain.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum GenderImpl implements Gender {
    MALE(1),
    FEMALE(0);

    private final int value;
    private static final List<Integer> GENDER_VALUES;

    static {
        GENDER_VALUES = new ArrayList<>();
        for (GenderImpl currencyGender : GenderImpl.values()) {
            GENDER_VALUES.add(currencyGender.value);
        }
    }

    GenderImpl(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<Integer> getValues() {
        return Collections.unmodifiableList(GENDER_VALUES);
    }
}
