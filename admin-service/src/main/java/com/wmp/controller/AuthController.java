package com.wmp.controller;

import com.wmp.config.JwtService;
import com.wmp.dto.AuthRequest;
import com.wmp.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                AuthResponse authRes = new AuthResponse(jwtService.generateToken(authRequest.getUsername()));
                return new ResponseEntity<>(authRes, HttpStatus.OK);
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
