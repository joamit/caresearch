package io.joamit.caresearch.manufacturer.service.repository;

import io.joamit.caresearch.api.commons.domain.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {
    Optional<Manufacturer> findByName(String name);
}
