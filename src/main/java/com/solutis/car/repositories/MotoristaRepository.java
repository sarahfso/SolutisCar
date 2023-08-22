package com.solutis.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutis.car.model.entity.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    //achar pelo id
    Motorista findById(long id);
}