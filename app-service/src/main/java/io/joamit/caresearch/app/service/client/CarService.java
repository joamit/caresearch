package io.joamit.caresearch.app.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service")
public interface CarService {

    @RequestMapping("/cars")
    String getCars();
}
