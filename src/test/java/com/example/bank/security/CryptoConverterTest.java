package com.example.bank.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CryptoConverterTest {
    @Autowired
    private CryptoConverter cryptoConverter;

    @Test
    public void testConvertToDatabaseColumn() {
        // Arrange, Act and Assert
        assertEquals("9EXdbdRZY0ZQuL3oU6vhBA==", this.cryptoConverter.convertToDatabaseColumn("Input Value"));
    }

    @Test
    public void testConvertToEntityAttribute() {
        // Arrange, Act and Assert
        assertThrows(RuntimeException.class, () -> this.cryptoConverter.convertToEntityAttribute("Db Data"));
        assertThrows(RuntimeException.class, () -> this.cryptoConverter.convertToEntityAttribute("AES"));
        assertEquals("", this.cryptoConverter.convertToEntityAttribute(""));
    }
}

