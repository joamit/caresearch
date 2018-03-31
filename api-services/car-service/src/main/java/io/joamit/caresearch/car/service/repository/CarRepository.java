package io.joamit.caresearch.car.service.repository;

import io.joamit.caresearch.api.commons.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findByName(String name);
}
