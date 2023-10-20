package com.example.SpringBanco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_conta")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numConta;
    private Double saldoConta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public BancoModel getBancoModel() {
        return bancoModel;
    }

    public void setBancoModel(BancoModel bancoModel) {
        this.bancoModel = bancoModel;
    }

    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private BancoModel bancoModel;







}
