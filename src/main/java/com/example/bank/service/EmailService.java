package com.example.bank.service;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}