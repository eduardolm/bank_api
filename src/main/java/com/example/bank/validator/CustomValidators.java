package com.example.bank.validator;

import java.time.LocalDate;

public class CustomValidators {

    public static boolean validadeAge(LocalDate birthDate) {
        if (birthDate.isBefore(LocalDate.now().minusYears(18))) {
            return true;
        }else {
            return false;
        }
    }
}
