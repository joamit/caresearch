package io.joamit.caresearch.app.service.client;

import io.joamit.caresearch.api.commons.domain.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "car-service")
public interface CarService {

    @RequestMapping(value = "/cars/", method = RequestMethod.GET)
    List<Car> findAll();

    @RequestMapping(value = "/cars/name/{name}", method = RequestMethod.GET)
    Optional<Car> findByName(@PathVariable("name") String name);

    @RequestMapping(value = "/cars/", method = RequestMethod.PUT)
    Car save(@RequestBody Car car);

}
