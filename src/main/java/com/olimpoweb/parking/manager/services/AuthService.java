package com.olimpoweb.parking.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olimpoweb.parking.manager.entities.User;
import com.olimpoweb.parking.manager.models.enums.RoleEnum;
import com.olimpoweb.parking.manager.models.requests.SignInRequest;
import com.olimpoweb.parking.manager.models.requests.SignUpRequest;
import com.olimpoweb.parking.manager.models.responses.JwtAuthResponse;
import com.olimpoweb.parking.manager.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public JwtAuthResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEnum.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }

    public JwtAuthResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
