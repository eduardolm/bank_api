package com.example.bank.helper;

import net.minidev.json.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TokenHelper {

    public JSONObject generateRandomToken(int length, boolean useLetters, boolean useNumbers) {

        JSONObject response = new JSONObject();
        response.put("Token", RandomStringUtils.random(length, useLetters, useNumbers));
        response.put("Expires", LocalDateTime.now().plusMinutes(10));

        return response;
    }

    public String generateStrongPassword() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(1, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(1);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        return pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
