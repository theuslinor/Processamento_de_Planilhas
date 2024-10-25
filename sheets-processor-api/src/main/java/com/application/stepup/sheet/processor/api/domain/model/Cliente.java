package com.application.stepup.sheet.processor.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String responsavel;
    private String nome;
    private String documento;
    private String endereco;
    private String dataNascimento;
    private String email;
    private String telefone;

}
