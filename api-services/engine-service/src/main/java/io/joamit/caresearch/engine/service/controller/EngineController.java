package io.joamit.caresearch.engine.service.controller;

import io.joamit.caresearch.api.commons.domain.Engine;
import io.joamit.caresearch.api.commons.domain.Manufacturer;
import io.joamit.caresearch.api.commons.util.Validations;
import io.joamit.caresearch.engine.service.client.ManufacturerService;
import io.joamit.caresearch.engine.service.repository.EngineRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Engine API")
@RequestMapping("/engines")
public class EngineController {

    private EngineRepository engineRepository;
    private ManufacturerService manufacturerService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public EngineController(EngineRepository engineRepository,
                            ManufacturerService manufacturerService) {
        this.engineRepository = engineRepository;
        this.manufacturerService = manufacturerService;
    }

    @ApiOperation(value = "Final all engines.",
            notes = "This api will return all the engine in the database. It should be used with caution.",
            produces = MediaType.APPLICATION_JSON_VALUE, response = Engine[].class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Engine> findAll() {
        return this.engineRepository.findAll();
    }

    @ApiOperation(value = "Find engine by name.", produces = MediaType.APPLICATION_JSON_VALUE, response = Engine.class)
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Optional<Engine> findByName(@PathVariable("name") String name) {
        return this.engineRepository.findByName(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Engine save(@RequestBody Engine engine) {
        Validations.validateEngine(engine);
        Manufacturer manufacturer = engine.getManufacturer();
        if (StringUtils.isEmpty(manufacturer.getId())) {
            Optional<Manufacturer> existingManufacturer = this.manufacturerService.findManufacturerByName(manufacturer.getName());
            if (existingManufacturer.isPresent()) {
                manufacturer = existingManufacturer.get();
            } else {
                manufacturer = this.manufacturerService.save(manufacturer);
            }
        }
        engine.setManufacturer(manufacturer);
        return this.engineRepository.save(engine);
    }
}
