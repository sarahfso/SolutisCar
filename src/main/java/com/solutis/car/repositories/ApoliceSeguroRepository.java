package com.solutis.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutis.car.model.entity.ApoliceSeguro;

@Repository
public interface ApoliceSeguroRepository extends JpaRepository<ApoliceSeguro, Long> {
}