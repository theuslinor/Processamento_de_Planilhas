package com.application.stepup.sheet.processor.api.domain.service;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlanilhaServicesTest {

    private final PlanilhaServices planilhaServices = new PlanilhaServices();

    private final String caminhoExistenteValido = "planilha_clientes.xlsx";

    private final String caminhoExistenteInvalido = "texto.txt";

    private final String caminhoInexistente = "qualquercoisa.xlsx";


    @Test
    public void testProcessarPlanilhaCaminhoExistenteValido() {
        assertDoesNotThrow(() -> planilhaServices.processarPlanilha(caminhoExistenteValido));
    }

    @Test
    public void testProcessarCaminhoExistenteInvalido(){
        assertThrows(NotOfficeXmlFileException.class, () -> planilhaServices.processarPlanilha(caminhoExistenteInvalido));
    }

    @Test
    public void testProcessarCaminhoInexistente(){
        assertThrows(FileNotFoundException.class, () -> planilhaServices.processarPlanilha(caminhoInexistente));
    }
}
