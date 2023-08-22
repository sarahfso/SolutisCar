package com.solutis.car.controller;

import com.solutis.car.model.dto.AluguelDTO;
import com.solutis.car.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aluguel")
public class AluguelController extends CrudController<AluguelDTO>{

    public AluguelController(@Autowired AluguelService service) {
        super(service);
    }
    
}
