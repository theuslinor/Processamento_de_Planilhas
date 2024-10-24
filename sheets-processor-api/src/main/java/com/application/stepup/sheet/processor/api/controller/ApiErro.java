package com.application.stepup.sheet.processor.api.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public class ApiErro {

    private final HttpStatus status;
    private final List<String> errors;

    public ApiErro(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiErro(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Collections.singletonList(error);
    }
}
