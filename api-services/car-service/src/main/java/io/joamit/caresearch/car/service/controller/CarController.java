package io.joamit.caresearch.car.service.controller;

import io.joamit.caresearch.api.commons.domain.Car;
import io.joamit.caresearch.api.commons.domain.Engine;
import io.joamit.caresearch.api.commons.domain.Manufacturer;
import io.joamit.caresearch.api.commons.util.Validations;
import io.joamit.caresearch.car.service.client.EngineService;
import io.joamit.caresearch.car.service.client.ManufacturerService;
import io.joamit.caresearch.car.service.repository.CarRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Car Api")
@RequestMapping("/cars")
public class CarController {

    private CarRepository carRepository;
    private EngineService engineService;
    private ManufacturerService manufacturerService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CarController(CarRepository carRepository,
                         EngineService engineService,
                         ManufacturerService manufacturerService) {
        this.carRepository = carRepository;
        this.engineService = engineService;
        this.manufacturerService = manufacturerService;
    }

    @ApiOperation(value = "Find all cars.",
            notes = "This api will return the entire database, to be used with caution.",
            produces = MediaType.APPLICATION_JSON_VALUE, response = Car[].class)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @ApiOperation(value = "Find a car by name.", produces = MediaType.APPLICATION_JSON_VALUE, response = Car.class)
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Car> findByName(@PathVariable("name") String name) {
        return this.carRepository.findByName(name);
    }

    @ApiOperation(value = "Save a new car.",
            notes = "Car must have a valid engine and manufacturer for it to be saved to the database. If engine or the manufacturer already exists, existing entries will be used instead!",
            produces = MediaType.APPLICATION_JSON_VALUE, response = Car.class)
    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car save(@RequestBody Car car) {
        Validations.validateCar(car);

        Manufacturer manufacturer = car.getManufacturer();
        if (StringUtils.isEmpty(manufacturer.getId())) {
            Manufacturer existingManufacturer = this.manufacturerService.findByName(manufacturer.getName());
            manufacturer = existingManufacturer == null ? this.manufacturerService.save(manufacturer) : existingManufacturer;
        }
        car.setManufacturer(manufacturer);

        Engine engine = car.getEngine();
        if (StringUtils.isEmpty(engine.getId())) {
            Engine existingEngine = this.engineService.findByName(engine.getName());
            if (existingEngine == null) {
                //we save the engine first and then add it back to the model
                engine = this.engineService.save(engine);
            } else {
                engine = existingEngine;
            }
        }
        car.setEngine(engine);

        return this.carRepository.save(car);
    }


}

