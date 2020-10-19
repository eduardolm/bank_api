package com.example.bank.validator;

import com.example.bank.dto.Transfer;

import java.time.LocalDate;

public class CustomValidators {

    public static boolean validateAge(LocalDate birthDate) {
        if (birthDate.isBefore(LocalDate.now().minusYears(18))) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean validateTransfer(Transfer transfer) {

        if (transfer.getId() == null
                || transfer.getTransferAmount() == 0.0
                || transfer.getTransferDate() == null
                || transfer.getTransferDoc() == null
                || transfer.getFromBank() == 0
                || transfer.getFromAccount() == 0
                || transfer.getFromAgency() == 0
                || transfer.getFromBankDoc() == null
                || transfer.getToAgency() == 0
                || transfer.getToAccount() == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
