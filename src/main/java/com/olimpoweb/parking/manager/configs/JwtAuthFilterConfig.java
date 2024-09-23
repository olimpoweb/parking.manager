package com.olimpoweb.parking.manager.configs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olimpoweb.parking.manager.services.JwtAuthService;
import com.olimpoweb.parking.manager.services.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilterConfig extends OncePerRequestFilter {

  private final JwtAuthService jwtAuthService;
  private final UserService userService;
  private final ObjectMapper mapper;

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
      throws ServletException, IOException {
    
    Map<String, Object> errorDetails = new HashMap<>();
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;

    try {

        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
          filterChain.doFilter(request, response);
          return;
        }

        jwt = authHeader.substring(7);
        userEmail = jwtAuthService.extractUserName(jwt);

        if (StringUtils.isNotEmpty(userEmail)
            && SecurityContextHolder.getContext().getAuthentication() == null) {
          UserDetails userDetails = userService.userDetailsService()
              .loadUserByUsername(userEmail);
              

            if (jwtAuthService.isTokenValid(jwt, userDetails)) {
              SecurityContext context = SecurityContextHolder.createEmptyContext();
              UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());
              authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              context.setAuthentication(authToken);
              SecurityContextHolder.setContext(context);
            }

        }

    } catch (Exception e) {
        errorDetails.put("message", "Authentication Error");
        errorDetails.put("details",e.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), errorDetails);
        return;
    }

    filterChain.doFilter(request, response);
  }
}