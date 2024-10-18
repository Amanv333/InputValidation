package com.validation.demo.util;

import java.util.regex.Pattern;

public class InputSanitizer1 {

    // Regex pattern to match HTML tags
    private static final String HTML_TAGS_REGEX = "<[^/!][^>]*>";
    //<[^/!][^>]*> <.*?>

    public static void validateInput(String input) {
        if (input == null) {
            return; // You can throw an exception if null is not acceptable
        }
        // Check for HTML tags
        if (Pattern.compile(HTML_TAGS_REGEX).matcher(input).find()) {
            throw new RuntimeException("Input contains invalid HTML tags.");
        }
    }
}
