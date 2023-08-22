package com.solutis.car.controller;

import com.solutis.car.model.dto.FabricanteDTO;
import com.solutis.car.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController extends CrudController<FabricanteDTO>{

    public FabricanteController(@Autowired FabricanteService service) {
        super(service);
    }
}
