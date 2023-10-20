package com.example.SpringBanco.controllers;

import com.example.SpringBanco.dtos.BancoRecordDto;
import com.example.SpringBanco.model.BancoModel;
import com.example.SpringBanco.repositories.BancoRepository;
import jakarta.validation.Valid;
import org.hibernate.mapping.Value;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BancoController {

    @Autowired
    BancoRepository bancoRepository;
    //Salvando agencias
    @PostMapping("/bancos")
    public ResponseEntity<BancoModel> addBanco(@RequestBody @Valid BancoRecordDto bancoRecordDto){
    var bancoModel = new BancoModel();
    BeanUtils.copyProperties(bancoRecordDto,bancoModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(bancoRepository.save(bancoModel));

    }
    //Listando bancos existentes

    @GetMapping("/bancos")

    public ResponseEntity<List<BancoModel>>getAllBancos(){

        return ResponseEntity.status(HttpStatus.OK).body(bancoRepository.findAll());
    }
    @GetMapping("/bancos/{id}")

    public ResponseEntity<Object>getOneBancos(@PathVariable(value = "id") int id ){
        Optional<BancoModel> bancoO = bancoRepository.findById(id);
        if (bancoO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agencia não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bancoO.get());
    }
    // editar agencia
    @PutMapping("/bancos/{id}")
    public ResponseEntity<Object>updateBanco(@PathVariable(value = "id") int id,
                                             @RequestBody @Valid BancoRecordDto bancoRecordDto){
        Optional<BancoModel> bancoO = bancoRepository.findById(id);
        if (bancoO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agencia não encontrada");
        }

        var bancoModel = bancoO.get();
        BeanUtils.copyProperties(bancoRecordDto,bancoModel);
        return ResponseEntity.status(HttpStatus.OK).body(bancoRepository.save(bancoModel));

    }

    @DeleteMapping("/bancos/{id}")
    public ResponseEntity<Object> excluirBanco( @PathVariable(value = "id")int id){
         Optional<BancoModel>bancoO = bancoRepository.findById(id);
        if (bancoO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agencia não encontrada");
        }
        bancoRepository.delete(bancoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Banco deletado com sucesso");
    }

}
