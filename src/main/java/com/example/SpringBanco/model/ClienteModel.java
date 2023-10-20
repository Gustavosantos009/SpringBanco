package com.example.SpringBanco.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="TB_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String endereco;
    private String CPF;
    private String RG;


    @OneToOne
    @JoinColumn(name = "conta_id")
    private ContaModel contaModel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public ContaModel getContaModel() {
        return contaModel;
    }

    public void setContaModel(ContaModel contaModel) {
        this.contaModel = contaModel;
    }
}
