package com.iist.vse900.controller;


import com.iist.vse900.configuration.JwtTokenUtil;
import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.model.JwtRequest;
import com.iist.vse900.domain.model.JwtResponse;
import com.iist.vse900.repository.impl.TokenRepo;
import com.iist.vse900.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping
public class LoginController extends BaseController {

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;
    @Autowired
    private TokenRepo tokenRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
