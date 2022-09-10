package io.github.CarolinaCedro.Car.api;

import io.github.CarolinaCedro.Car.dto.CarroDto;
import io.github.CarolinaCedro.Car.entities.Carro;
import io.github.CarolinaCedro.Car.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    CarroService carroService;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(carroService.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity getByid(@PathVariable("id") Long id) {
        CarroDto carro = carroService.getById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarroByTipo(@PathVariable("tipo") String tipo) {
        List<Carro> carros = carroService.getCarroByTipo(tipo);
        return carros.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity post(@RequestBody Carro carro) {
        CarroDto c = carroService.save(carro);
        URI location = getUri(c.getId());
        return ResponseEntity.created(null).build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        carro.setId(id);

        CarroDto c = carroService.update(carro, id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        carroService.delete(id);
        return ResponseEntity.ok().build();
    }

}
