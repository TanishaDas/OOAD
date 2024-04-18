package com.example.application;

public class CeaserCypher implements cipher {

    @Override
    public String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt(String encryptedText, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
                decryptedText.append(shiftedChar);
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
}

