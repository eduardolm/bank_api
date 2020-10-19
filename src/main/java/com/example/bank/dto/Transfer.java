package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class Transfer {

    private UUID id;
    @NotBlank(message = "{transfer.amount.notblank}")
    @NotNull(message = "{transfer.amount.notnull}")
    private double transferAmount;
    @NotNull(message = "{transfer.date.notnull}")
    private LocalDate transferDate;
    @NotBlank(message = "{transfer.transferdoc.notblank}")
    @NotNull(message = "{transfer.transferdoc.notnull}")
    private UUID transferDoc;
    @NotBlank(message = "{transfer.frombank.notblank}")
    @NotNull(message = "{transfer.frombank.notnull}")
    private int fromBank;
    @NotBlank(message = "{transfer.fromaccount.notblank}")
    @NotNull(message = "{transfer.fromaccount.notnull}")
    private int fromAccount;
    @NotBlank(message = "{transfer.fromagency.notblank}")
    @NotNull(message = "{transfer.fromagency.notnull}")
    private int fromAgency;
    @NotBlank(message = "{transfer.frombankdoc.notblank}")
    @NotNull(message = "{transfer.frombankdoc.notnull}")
    private UUID fromBankDoc;
    @NotBlank(message = "{transfer.toagency.notblank}")
    @NotNull(message = "{transfer.toagency.notnull}")
    private int toAgency;
    @NotBlank(message = "{transfer.toaccount.notblank}")
    @NotNull(message = "{transfer.toaccount.notnull}")
    private int toAccount;
}
