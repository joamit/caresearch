package io.joamit.caresearch.car.service.client;

import io.joamit.caresearch.api.commons.domain.Engine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient("engine-service")
public interface EngineService {

    @RequestMapping(value = "/name/{name}/manufacturer/{manufacturer}", method = RequestMethod.GET)
    Optional<Engine> findEngineByNameAndManufacturer(@PathVariable("name") String name, @PathVariable("manufacturer") String manufacturer);

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Engine saveEngine(@RequestBody Engine engine);

}
