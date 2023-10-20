package com.example.SpringBanco.controllers;

import com.example.SpringBanco.dtos.ClienteRecordDto;
import com.example.SpringBanco.model.ClienteModel;
import com.example.SpringBanco.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;
    @PostMapping("/clientes")
    public ResponseEntity<ClienteModel> addCliente(@RequestBody @Valid ClienteRecordDto clienteRecordDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto,clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id")int id){

        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clinte não encontrado na base de dados");
        }
         return ResponseEntity.status(HttpStatus.OK).body(clienteO.get());
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Object> updateClinte(@PathVariable(value = "id")int id,
                                               @RequestBody @Valid ClienteRecordDto clienteRecordDto ){

        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clinte não encontrado na base de dados");
        }
        var clienteModel = clienteO.get();
        BeanUtils.copyProperties(clienteRecordDto,clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }
    @DeleteMapping("/Clientes/{id}")
    public ResponseEntity<Object>excluirCliente(@PathVariable(value = "id") int id ){
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clinte não encontrado na base de dados");
        }
        clienteRepository.delete(clienteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Clinte delertado com sucesso");
    }


}
