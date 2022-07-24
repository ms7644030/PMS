package com.cloudgateway.authenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ResponseStatus(HttpStatus.UNAUTHORIZED)

public class JwtTokenIncorrectStructureException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public JwtTokenIncorrectStructureException(String message) {
        super(message);
        
    }
}
