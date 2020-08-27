package com.unlugarenlacosta.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

// Esta clase sirve para encriptar las contraseñas
@Component
public class PasswordEncoderGenerator {

    public static void main(String[] args) {

    }

    // Metodo para encriptar una contraseña
    public static String encode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
