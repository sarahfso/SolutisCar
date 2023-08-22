package com.solutis.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.solutis.car.model.dto.CarroDTO;
import com.solutis.car.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController extends CrudController<CarroDTO>{
    private CarroService service;

    public CarroController(@Autowired CarroService service) {
        super(service);
        this.service = service;
    }
    
    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroDTO>> getVeiculosDisponiveis(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) List<String> acessorios) {

        List<CarroDTO> veiculosDisponiveis = service.findVeiculosDisponiveis(categoria, acessorios);
        return ResponseEntity.ok(veiculosDisponiveis);
    }

}
