package com.solutis.car.controller;

import com.solutis.car.model.dto.ModeloCarroDTO;
import com.solutis.car.service.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos")
public class ModeloCarroController extends CrudController<ModeloCarroDTO>{

    public ModeloCarroController(@Autowired ModeloCarroService service) {
        super(service);
    }
}
