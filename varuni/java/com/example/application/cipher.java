package com.example.application;

public interface cipher {
    String encrypt(String plainText, int shift);
    String decrypt(String encryptedText, int shift);
}

