package com.example.SpringBanco.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BancoRecordDto(@NotNull int numAgencia, @NotBlank  String nomeAgencia, @NotBlank String endereco) {
}
