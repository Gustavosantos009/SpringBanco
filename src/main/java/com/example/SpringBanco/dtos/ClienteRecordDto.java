package com.example.SpringBanco.dtos;

import com.example.SpringBanco.model.ContaModel;
import jakarta.validation.constraints.NotBlank;

public record ClienteRecordDto(@NotBlank String nome, @NotBlank String endereco, @NotBlank String CPF, @NotBlank String RG,
                               ContaModel contaModel) {
}
