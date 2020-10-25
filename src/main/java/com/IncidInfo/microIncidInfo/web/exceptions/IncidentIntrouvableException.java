package com.IncidInfo.microIncidInfo.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncidentIntrouvableException extends RuntimeException {
    public IncidentIntrouvableException(String s) {
        super(s);
    }
}
