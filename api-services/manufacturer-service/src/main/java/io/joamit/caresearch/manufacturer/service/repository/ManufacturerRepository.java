package io.joamit.caresearch.manufacturer.service.repository;

import io.joamit.caresearch.api.commons.domain.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {
}
