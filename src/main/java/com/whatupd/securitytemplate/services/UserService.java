package com.whatupd.securitytemplate.services;

import com.whatupd.securitytemplate.model.ApplicationUser;
import com.whatupd.securitytemplate.model.Role;
import com.whatupd.securitytemplate.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("In side UserService");

        return userRepository.findByUsername(username).orElseThrow(() ->new UsernameNotFoundException("not valid Usr"));
    }
}
