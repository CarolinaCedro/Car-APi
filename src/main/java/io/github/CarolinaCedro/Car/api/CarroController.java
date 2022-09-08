package io.github.CarolinaCedro.Car.api;

import io.github.CarolinaCedro.Car.entities.Carro;
import io.github.CarolinaCedro.Car.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    CarroService carroService;

    @GetMapping
    public Iterable<Carro> get() {
        return carroService.getCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro>getByid(@PathVariable("id") Long id){
        return carroService.getById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro>getCarroByTipo(@PathVariable("tipo") String tipo){
        return carroService.getCarroByTipo(tipo);
    }

}
