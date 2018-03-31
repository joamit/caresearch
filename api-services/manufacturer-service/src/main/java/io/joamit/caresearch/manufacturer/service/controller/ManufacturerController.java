package io.joamit.caresearch.manufacturer.service.controller;

import io.joamit.caresearch.api.commons.domain.Manufacturer;
import io.joamit.caresearch.api.commons.util.Validations;
import io.joamit.caresearch.manufacturer.service.repository.ManufacturerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Manufacturer API")
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @ApiOperation(value = "Find all manufacturers.", notes = "This api returns all the manufacturers from database, it should be used with caution!", produces = MediaType.APPLICATION_JSON_VALUE, response = Manufacturer[].class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @ApiOperation(value = "Find manufacturer by name.", produces = MediaType.APPLICATION_JSON_VALUE, response = Manufacturer.class)
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Optional<Manufacturer> findByName(@PathVariable("name") String name) {
        return this.manufacturerRepository.findByName(name);
    }

    @ApiOperation(value = "Save a new manufacturer.", produces = MediaType.APPLICATION_JSON_VALUE, response = Manufacturer.class)
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Manufacturer save(@RequestBody Manufacturer manufacturer) {
        Validations.validateManufacturer(manufacturer);
        return this.manufacturerRepository.save(manufacturer);
    }
}
