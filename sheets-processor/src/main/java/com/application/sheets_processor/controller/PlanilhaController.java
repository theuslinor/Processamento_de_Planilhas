package com.application.sheets_processor.controller;

import com.application.sheets_processor.services.PlanilhaServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class PlanilhaController {

    private final PlanilhaServices planilhaServices;

    @PostMapping("/processar")
    public ResponseEntity<String> processarPlanilha() throws IOException {
        planilhaServices.processarPlanilha("planilha_clientes.xlsx");
        return ResponseEntity.ok("Planilha processada com sucesso!");
    }
}
