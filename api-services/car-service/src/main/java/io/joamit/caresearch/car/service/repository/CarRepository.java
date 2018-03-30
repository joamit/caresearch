package io.joamit.caresearch.car.service.repository;

import io.joamit.caresearch.api.commons.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CarRepository extends MongoRepository<Car, String> {
}
