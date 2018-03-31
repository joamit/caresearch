package io.joamit.caresearch.engine.service.client;

import io.joamit.caresearch.api.commons.domain.Manufacturer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("manufacturer-service")
public interface ManufacturerService {

    @RequestMapping(value = "/manufacturers/name/{name}", method = RequestMethod.GET)
    Manufacturer findManufacturerByName(@PathVariable("name") String name);

    @RequestMapping(value = "/manufacturers/", method = RequestMethod.PUT)
    Manufacturer save(@RequestBody Manufacturer manufacturer);

    @RequestMapping(value = "/manufacturers/", method = RequestMethod.GET)
    List<Manufacturer> findAll();

}
