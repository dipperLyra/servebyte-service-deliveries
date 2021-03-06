package com.delivery.servebyte;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderUtil {

    public static String encode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean decode(String hash, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(password, hash);
    }
}
