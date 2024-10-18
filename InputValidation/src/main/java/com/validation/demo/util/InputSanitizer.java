package com.validation.demo.util;

public class InputSanitizer {

    // Method to sanitize input by removing special characters
    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }
        // Remove special characters, keeping only alphanumeric characters and spaces
        return input.replaceAll("[^a-zA-Z0-9@: ]", "");
    }
}
