package io.github.CarolinaCedro.Car.service;

import io.github.CarolinaCedro.Car.entities.Carro;
import io.github.CarolinaCedro.Car.reposytory.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }


    public Optional<Carro> getById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }
}
