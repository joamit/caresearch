package io.joamit.caresearch.api.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service")
public interface CarServiceClient {

    @RequestMapping("/cars")
    public String getCars();
}
