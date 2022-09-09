package io.github.CarolinaCedro.Car.reposytory;

import io.github.CarolinaCedro.Car.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro,Long> {
    List<Carro> findByTipo(String tipo);
}
