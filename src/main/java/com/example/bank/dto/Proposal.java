package com.example.bank.dto;

import com.example.bank.enums.State;
import com.example.bank.validator.constraints.CEP;
import com.example.bank.validator.constraints.ValueOfEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Proposal {

    private UUID id;
    @NotBlank
    @CEP(message = "{zip.notvalid}")
    private String zip;
    @NotBlank(message = "{street.notblank}")
    private String street;
    @NotBlank(message = "{neighborhood.notblank}")
    private String neighborhood;
    @NotBlank(message = "{complement.notblank}")
    private String complement;
    @NotBlank(message = "{city.notblank}")
    private String city;
    @ValueOfEnum(enumClass = State.class, message = "{enum.value}")
    @NotBlank(message = "{state.notblank}")
    private String state;
}
