package com.adilsdeals.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@EnableJpaRepositories(basePackages = "com.adilsdeals")
public class SpringConfiguration {

    private static final String ALGORITHM = "MD5";

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(ALGORITHM);
    }
}
