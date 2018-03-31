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
    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    @ApiOperation(value = "Find a car by id.", produces = MediaType.APPLICATION_JSON_VALUE, response = Car.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Car> getCar(@PathVariable("id") String id) {
        return this.carRepository.findById(id);
    }

    @ApiOperation(value = "Save a new car.",
            notes = "Car must have a valid engine and manufacturer for it to be saved to the database. If engine or the manufacturer already exists, existing entries will be used instead!",
            produces = MediaType.APPLICATION_JSON_VALUE, response = Car.class)
    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Car> saveCar(@RequestBody Car car) {
        Validations.validateCar(car);

        Manufacturer manufacturer = car.getManufacturer();
        if (StringUtils.isEmpty(manufacturer.getId())) {
            Optional<Manufacturer> existingManufacturer = this.manufacturerService.findManufacturerByName(manufacturer.getName());
            if (existingManufacturer.isPresent()) {
                manufacturer = existingManufacturer.get();
            } else {
                //we save the manufacturer first and then add it back to the model
                manufacturer = this.manufacturerService.saveManufacturer(manufacturer);
            }
        }
        car.setManufacturer(manufacturer);

        Engine engine = car.getEngine();
        if (StringUtils.isEmpty(engine.getId())) {
            Optional<Engine> existingEngine = this.engineService.findEngineByNameAndManufacturer(engine.getName(), manufacturer.getName());
            if (existingEngine.isPresent()) {
                engine = existingEngine.get();
            } else {
                //we save the engine first and then add it back to the model
                engine = this.engineService.saveEngine(engine);
            }
        }
        car.setEngine(engine);

        car = this.carRepository.save(car);
        return Optional.of(car);
    }


}

