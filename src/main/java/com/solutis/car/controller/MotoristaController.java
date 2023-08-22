package com.solutis.car.controller;

import com.solutis.car.model.dto.MotoristaDTO;
import com.solutis.car.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class MotoristaController extends CrudController<MotoristaDTO> {

    public MotoristaController(@Autowired MotoristaService service) {
        super(service);
    }

}
