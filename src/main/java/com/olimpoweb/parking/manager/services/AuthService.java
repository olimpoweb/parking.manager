package com.olimpoweb.parking.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthService jwtService;
    private final AuthenticationManager authenticationManager;
    
    /**
     * Sign Up
     * @param request
     * @return
     */
    public JwtAuthResponse signUp(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEnum.USER).build();
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            log.error(HttpStatus.FORBIDDEN + "User with this email already exist");
            throw new DataIntegrityViolationException("User with this email already exist");
        }

        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder()
          .token(jwt)
          .user(user).build();
    }

    /**
     * Login User with email and password
     * @param request
     * @return
     */
    public JwtAuthResponse login(SignInRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email."));
        
        var jwt = jwtService.generateToken(user);
        
        return JwtAuthResponse.builder().token(jwt).user(user).build();
    }
}
