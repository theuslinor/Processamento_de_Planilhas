package com.application.sheets_processor.controller;

import com.application.sheets_processor.services.PlanilhaServices;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> processarPlanilha(@RequestParam String caminho) throws IOException {

        try{
            planilhaServices.processarPlanilha(caminho);
            return ResponseEntity.ok("Planilha processada com sucesso!");

        } catch (FileNotFoundException e) {
            return ResponseEntity.badRequest().body("Arquivo não encontrado: " + e.getMessage());

        } catch (InvalidFormatException e) {
            return ResponseEntity.badRequest().body("Formato inválido da planilha: " + e.getMessage());

        } catch (NotOfficeXmlFileException e){
            return ResponseEntity.badRequest().body("Formato inválido: " + e.getMessage());
        }

        catch (IOException e) {
            return ResponseEntity.badRequest().body("Erro de I/O ao processar o arquivo: " + e.getMessage());
        }

    }
}
