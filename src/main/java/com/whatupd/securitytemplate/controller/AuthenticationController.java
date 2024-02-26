package com.whatupd.securitytemplate.controller;

import com.whatupd.securitytemplate.dto.RegistrationDTO;
import com.whatupd.securitytemplate.model.ApplicationUser;
import com.whatupd.securitytemplate.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//improve security change the crossOrigin
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(),registrationDTO.getPassword());
    }
}
