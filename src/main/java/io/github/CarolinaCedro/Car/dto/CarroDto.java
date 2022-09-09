package io.github.CarolinaCedro.Car.dto;

import io.github.CarolinaCedro.Car.entities.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
public class CarroDto {
    private Long id;
    private String nome;
    private String tipo;

    public static CarroDto create(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDto.class);
    }


}
