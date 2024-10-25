package com.application.stepup.sheet.processor.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {

    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

}
