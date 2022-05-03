package com.adilsdeals.authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
    String username;
    String password;
}
