package com.application.stepup.sheet.processor.api.domain.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PlanilhaServices {

    private static final Logger logger = LoggerFactory.getLogger(PlanilhaServices.class);

    @Autowired
    private GerenciadorPlanilha gerenciadorPlanilha;

    public void processarPlanilha(String caminho) throws IOException, InvalidFormatException {

        gerenciadorPlanilha.processarPlanilha(caminho);

    }
}


