package com.example.architecture.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String nickName;
    private String password;
}
