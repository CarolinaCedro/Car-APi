package io.github.CarolinaCedro.Car.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String Get() {
        return "Api dos carros";
    }

}
