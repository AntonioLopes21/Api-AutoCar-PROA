package com.autocar.autocarbackend.controllers;


import com.autocar.autocarbackend.models.Carro;
import com.autocar.autocarbackend.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carro")
public class CarroController {
    @Autowired
    CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroService.findAll();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable Long id) {
        Carro carrin = carroService.findById(id);
        return ResponseEntity.ok(carrin);
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carrin)  {
        Carro carro = carroService.save(carrin);
        return ResponseEntity.ok(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carrin) {
        Carro carro = carroService.update(carrin, id);
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
