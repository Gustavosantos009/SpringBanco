package com.example.SpringBanco.repositories;

import com.example.SpringBanco.model.BancoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BancoRepository extends JpaRepository<BancoModel, Integer> {
}
