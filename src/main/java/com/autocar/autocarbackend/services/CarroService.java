package com.autocar.autocarbackend.services;

import com.autocar.autocarbackend.models.Carro;
import com.autocar.autocarbackend.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository repository;

    @Transactional(readOnly = true)
    public List<Carro> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Carro findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Carro update(Carro carro, Long id) {
        Carro carroAux = repository.getReferenceById(id);
        carroAux.setNome(carro.getNome());
        carroAux.setMarca(carro.getMarca());
        carroAux.setModelo(carro.getModelo());
        carroAux.setPreco(carro.getPreco());

        repository.save(carroAux);
        return carroAux;
    }


}
