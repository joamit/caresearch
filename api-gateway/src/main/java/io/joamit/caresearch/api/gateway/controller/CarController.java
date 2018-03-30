package io.joamit.caresearch.api.gateway.controller;

import io.joamit.caresearch.api.gateway.client.CarServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarServiceClient carServiceClient;

    @RequestMapping("/cars")
    public String getAllCars() {
        return carServiceClient.getCars();
    }

}

