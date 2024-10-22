package com.application.sheets_processor.services;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class PlanilhaServices {
    // Verificar se o arquivo existe
    // Verificar se o arquivo é xlsx
    // Verificar se o arquivo esta corrompido ou não

    public void processarPlanilha(String caminho) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(caminho); // Abre o arquivo como um InputStreamtry

        try (InputStream inputStream = classPathResource.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {}

    }
}
