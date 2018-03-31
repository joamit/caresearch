package io.joamit.caresearch.car.service.client;

import io.joamit.caresearch.api.commons.domain.Manufacturer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient("manufacturer-service")
public interface ManufacturerService {

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    Optional<Manufacturer> findManufacturerByName(@PathVariable("name") String name);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Manufacturer save(@RequestBody Manufacturer manufacturer);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Manufacturer> findAll();
}
