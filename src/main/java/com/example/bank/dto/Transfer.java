package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class Transfer {

    private UUID id;
    @NotNull(message = "{transfer.amount.notnull}")
    private double transferAmount;
    @NotNull(message = "{transfer.date.notnull}")
    private LocalDate transferDate;
    @NotNull(message = "{transfer.transferdoc.notnull}")
    private UUID transferDoc;
    @NotNull(message = "{transfer.frombank.notnull}")
    private int fromBank;
    @NotNull(message = "{transfer.fromaccount.notnull}")
    private int fromAccount;
    @NotNull(message = "{transfer.fromagency.notnull}")
    private int fromAgency;
    @NotNull(message = "{transfer.frombankdoc.notnull}")
    private UUID fromBankDoc;
    @NotNull(message = "{transfer.toagency.notnull}")
    private int toAgency;
    @NotNull(message = "{transfer.toaccount.notnull}")
    private int toAccount;
}
