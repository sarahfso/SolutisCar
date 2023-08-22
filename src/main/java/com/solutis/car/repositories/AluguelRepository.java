package com.solutis.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutis.car.model.entity.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
