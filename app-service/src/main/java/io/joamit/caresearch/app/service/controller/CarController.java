package io.joamit.caresearch.app.service.controller;

import io.joamit.caresearch.api.commons.domain.Car;
import io.joamit.caresearch.app.service.client.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Car> findAll() {
        return this.carService.findAll();
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Optional<Car> findByName(@PathVariable("name") String name) {
        return this.carService.findByName(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Car save(@RequestBody Car car) {
        return this.carService.save(car);
    }


}
