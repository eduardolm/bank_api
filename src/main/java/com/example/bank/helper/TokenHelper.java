package com.example.bank.helper;

import net.minidev.json.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

public class TokenHelper {

    public JSONObject generateRandomToken(int length, boolean useLetters, boolean useNumbers) {

        JSONObject response = new JSONObject();
        response.put("Token", RandomStringUtils.random(length, useLetters, useNumbers));
        response.put("Expires", LocalDateTime.now().plusMinutes(10));

        return response;
    }
}
