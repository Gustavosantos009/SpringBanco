package com.example.SpringBanco.dtos;

import com.example.SpringBanco.model.BancoModel;
import jakarta.validation.constraints.NotNull;

public record ContaRecordDto(@NotNull int numConta, @NotNull Double saldoConta, BancoModel bancoModel) {
}
