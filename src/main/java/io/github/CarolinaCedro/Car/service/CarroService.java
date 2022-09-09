package io.github.CarolinaCedro.Car.service;

import io.github.CarolinaCedro.Car.dto.CarroDto;
import io.github.CarolinaCedro.Car.entities.Carro;
import io.github.CarolinaCedro.Car.reposytory.CarroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDto> getCarros() {
        List<CarroDto> list = rep.findAll().stream().map(CarroDto::create).collect(Collectors.toList());
        return list;
    }


    public CarroDto getById(Long id) {
        Optional<Carro> carro = rep.findById(id);
        return carro.map(CarroDto::create).orElseThrow(() -> new ObjectNotFoundException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
    }

    public List<Carro> getCarroByTipo(String tipo) {
        List<Carro> carros = rep.findByTipo(tipo);
        return carros;
    }

    public CarroDto save(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possivel inserir o registro");
        return CarroDto.create(rep.save(carro));
    }

    public CarroDto update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return CarroDto.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }

}
