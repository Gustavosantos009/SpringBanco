package com.example.SpringBanco.repositories;

import com.example.SpringBanco.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository  extends JpaRepository<ContaModel,Integer> {
}
