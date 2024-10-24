package com.application.stepup.sheet.processor.api.controller;

import com.application.stepup.sheet.processor.api.domain.service.PlanilhaServices;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class PlanilhaController {

    private final PlanilhaServices planilhaServices;

    @PostMapping("/processar")
    public ResponseEntity<String> processarPlanilha(@RequestParam String caminho) throws IOException, InvalidFormatException {
        planilhaServices.processarPlanilha(caminho);
        return ResponseEntity.ok("Planilha processada com sucesso!");
    }
}
