package com.application.stepup.sheet.processor.api.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class ControllerCentralDeExcecoes {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErro> ExceptionHandler(Exception e){
        ApiErro apiErro = new ApiErro(HttpStatus.BAD_REQUEST, "Exceção genérica:" + e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ApiErro> FileNotFoundException(FileNotFoundException e){
        ApiErro apiErro = new ApiErro(HttpStatus.NOT_FOUND, "Arquivo não encontrado: " + e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ApiErro> InvalidFormatExceptionHandler(InvalidFormatException e){
        ApiErro apiErro = new ApiErro(HttpStatus.BAD_REQUEST, "Formato do arquivo é inválido: " + e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

    @ExceptionHandler(NotOfficeXmlFileException.class)
    public ResponseEntity<ApiErro> NotOfficeXmlFileExceptionHandler(NotOfficeXmlFileException e){
        ApiErro apiErro = new ApiErro(HttpStatus.BAD_REQUEST,"Arquivo fornecido não é uma planilha: " + e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiErro> IOExceptionHandler(IOException e){
        ApiErro apiErro = new ApiErro(HttpStatus.INTERNAL_SERVER_ERROR,"Ocorreu um erro no processamento do arquivo: " + e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

}
