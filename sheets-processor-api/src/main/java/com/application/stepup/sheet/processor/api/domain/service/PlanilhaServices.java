package com.application.stepup.sheet.processor.api.domain.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PlanilhaServices {


    public void processarPlanilha(String caminho) throws IOException, InvalidFormatException {
        ClassPathResource classPathResource = new ClassPathResource(caminho);

        InputStream inputStream = classPathResource.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);

    }
}

