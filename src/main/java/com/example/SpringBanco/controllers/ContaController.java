package com.example.SpringBanco.controllers;

import com.example.SpringBanco.dtos.ClienteRecordDto;
import com.example.SpringBanco.dtos.ContaRecordDto;
import com.example.SpringBanco.model.BancoModel;
import com.example.SpringBanco.model.ClienteModel;
import com.example.SpringBanco.model.ContaModel;
import com.example.SpringBanco.repositories.ContaRepository;
import com.sun.net.httpserver.HttpsServer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaController {

    @Autowired
    ContaRepository contaRepository;


    @PostMapping("/contas")
    public ResponseEntity<ContaModel>addConta(@RequestBody ContaRecordDto contaRecordDto){

        var contaModel = new ContaModel();
        BeanUtils.copyProperties(contaRecordDto,contaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(contaModel));
    }
    @GetMapping("/contas")
    public ResponseEntity<List<ContaModel>> getAllConta(){

        return ResponseEntity.status(HttpStatus.OK).body(contaRepository.findAll());
    }
    @GetMapping("/contas/{id}")
    public ResponseEntity<Object> getOneConta(@PathVariable(value = "id")int id){

        Optional<ContaModel> contaO = contaRepository.findById(id);
        if(contaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("conta não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaO.get());
    }
    @PutMapping("/contas/{id}")
    public ResponseEntity<Object> updateConta(@PathVariable(value = "id")int id,
                                               @RequestBody @Valid ContaRecordDto contaRecordDto ){

        Optional<ContaModel> contaO = contaRepository.findById(id);
        if(contaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrado na base de dados");
        }
        var contaModel = contaO.get();
        BeanUtils.copyProperties(contaRecordDto,contaModel);
        return ResponseEntity.status(HttpStatus.OK).body(contaRepository.save(contaModel));
    }
    @DeleteMapping("/contas/{id}")
    public ResponseEntity<Object> excluirConta(@PathVariable(value = "id")int id){

        Optional<ContaModel> contaO = contaRepository.findById(id);
        if(contaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrado na base de dados");
        }
        contaRepository.delete(contaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso");
    }
}
