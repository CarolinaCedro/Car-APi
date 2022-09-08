package io.github.CarolinaCedro.Car.reposytory;

import io.github.CarolinaCedro.Car.entities.Carro;
import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository <Carro,Long>{
    Iterable<Carro> findByTipo(String tipo);
}
