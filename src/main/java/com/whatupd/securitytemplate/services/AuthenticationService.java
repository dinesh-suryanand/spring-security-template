package com.whatupd.securitytemplate.services;

import com.whatupd.securitytemplate.model.ApplicationUser;
import com.whatupd.securitytemplate.model.Role;
import com.whatupd.securitytemplate.repository.RoleRepository;
import com.whatupd.securitytemplate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUser registerUser(String userName, String password) {
        String encodePassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").orElse(null);
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(0,userName,encodePassword,authorities));
    }

}
