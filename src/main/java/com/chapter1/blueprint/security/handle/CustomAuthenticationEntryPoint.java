package com.chapter1.blueprint.security.handle;

import com.chapter1.blueprint.exception.util.JsonResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final JsonResponseUtil jsonResponseUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        jsonResponseUtil.sendErrorResponse(response, HttpStatus.UNAUTHORIZED,
                "Unauthorized access attempt. Reason: " + authException.getMessage(),
                "Unauthorized access due to authentication failure.");
    }
}