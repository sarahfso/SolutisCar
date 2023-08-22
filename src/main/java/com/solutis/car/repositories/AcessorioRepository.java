package com.solutis.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutis.car.model.entity.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
}