package org.khasanof.authservice.security.filters;


import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.khasanof.authservice.dto.authentication.LoginDTO;
import org.khasanof.authservice.response.ApplicationError;
import org.khasanof.authservice.response.Data;
import org.khasanof.authservice.response.tokens.Tokens;
import org.khasanof.authservice.security.jwt.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginDTO loginDto = new ObjectMapper().readValue(request.getReader(), LoginDTO.class);
            log.info("Username is: {}", loginDto.getEmail());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException, IOException {
        User user = (User) authentication.getPrincipal();
        Date expiryForAccessToken = JwtUtils.getExpiry();
        Date expiryForRefreshToken = JwtUtils.getExpiryForRefreshToken();

        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiryForAccessToken)
                .withIssuer(request.getRequestURL().toString())
                .sign(JwtUtils.getAlgorithm());

        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiryForRefreshToken)
                .withIssuer(request.getRequestURL().toString())
                .sign(JwtUtils.getAlgorithm());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), new Data<>(new Tokens(accessToken, refreshToken)));

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Data<ApplicationError> resp = new Data<>(
                ApplicationError.builder()
                        .message(failed.getMessage())
                        .path(request.getRequestURL().toString())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build()
        );
        new ObjectMapper().writeValue(response.getOutputStream(), resp);
    }
}