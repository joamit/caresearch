package io.joamit.caresearch.car.service.client;

import io.joamit.caresearch.api.commons.domain.Engine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("engine-service")
public interface EngineService {

    @RequestMapping(value = "/engines/name/{name}", method = RequestMethod.GET)
    Engine findByName(@PathVariable("name") String name);

    @RequestMapping(value = "/engines/", method = RequestMethod.PUT)
    Engine save(@RequestBody Engine engine);

    @RequestMapping(value = "/engines/", method = RequestMethod.GET)
    List<Engine> findAll();

}
