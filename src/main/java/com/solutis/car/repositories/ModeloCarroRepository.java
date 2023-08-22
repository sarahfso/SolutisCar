package com.solutis.car.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutis.car.model.entity.ModeloCarro;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    Optional<ModeloCarro> findByDescricao(String descricao);
}