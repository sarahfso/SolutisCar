package com.solutis.car.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.solutis.car.service.CrudService;

import java.util.List;

public abstract class CrudController<T> {
    private CrudService service;

    public CrudController(CrudService service) {
        this.service = service;
    }

    @Operation(
            summary = "Obtem por id",
            description = "Retorna as informações do objeto pelo do id",
            tags = { "id", "get" })
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        return ResponseEntity.ok( (T) service.findById(id));
    }

    @Operation(
            summary = "Obtem todos",
            description = "Retorna as informações de todos os objetos",
            tags = { "todos", "get" })
    @GetMapping
    public  ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok( (List<T>) service.findAll());
    }


    @Operation(
            summary = "Salva um objeto",
            description = "Retorna as informações do objeto que foram salvas",
            tags = { "salvar", "post" })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> add(@RequestBody T payload) {
        return ResponseEntity.ok((T) service.add(payload));
    }

    @Operation(
            summary = "Altera um objeto",
            description = "Retorna as informações do objeto que foi alterado",
            tags = { "alterar", "post" })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T payload) {
        return ResponseEntity.ok((T) service.update(id, payload));
    }

    @Operation(
            summary = "deleta por id",
            description = "Deleta as informações do objeto pelo do id",
            tags = { "id", "delete" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
