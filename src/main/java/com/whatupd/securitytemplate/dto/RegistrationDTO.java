package com.whatupd.securitytemplate.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class RegistrationDTO {
    private String username;
    private String password;

}
