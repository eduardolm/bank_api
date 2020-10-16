package com.example.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProposalNotFoundException extends RuntimeException {
//    public ProposalNotFoundException(String exception) {
//        super(exception);
//    }
}