package com.flock.demo.utils;

import org.owasp.encoder.Encode;

public class InputSanitizer {

    public static String cleanInput(String input) {
        return Encode.forJava(input);
    }

}
