package com.example.SpringBanco.repositories;

import com.example.SpringBanco.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel,Integer> {

}
