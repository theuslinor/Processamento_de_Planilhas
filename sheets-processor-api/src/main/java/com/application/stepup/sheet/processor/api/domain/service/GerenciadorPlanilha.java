package com.application.stepup.sheet.processor.api.domain.service;

import com.application.stepup.sheet.processor.api.domain.model.Cliente;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class GerenciadorPlanilha {

    private static final Logger logger = LoggerFactory.getLogger(GerenciadorPlanilha.class);

    public void processarPlanilha(String caminho) throws IOException, InvalidFormatException {

        List<Cliente> clientes = new ArrayList<>();
        Sheet planilha = inicializarPlanilha(caminho);

        for (Row linha : planilha ) {
            if (linha.getRowNum() == 0) continue;

            Cliente cliente = extrairCliente(linha);
            clientes.add(cliente);

        }
    }

    private Sheet inicializarPlanilha(String caminho) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(caminho);
        InputStream inputStream = classPathResource.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        return workbook.getSheetAt(0);

    }

    private Cliente extrairCliente (Row linha){
        Cliente cliente = new Cliente();

        cliente.setResponsavel(linha.getCell(0).getStringCellValue());
        cliente.setNome(linha.getCell(1).getStringCellValue());
        cliente.setDocumento(linha.getCell(2).getStringCellValue());
        cliente.setEndereco(linha.getCell(3).getStringCellValue());
        cliente.setDataNascimento(linha.getCell(4).getStringCellValue());
        cliente.setEmail(linha.getCell(5).getStringCellValue());
        cliente.setTelefone(linha.getCell(6).getStringCellValue());

        logger.info(cliente.toString());

        return cliente;
        
    }


}
