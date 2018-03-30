package io.joamit.caresearch.engine.service.repository;

import io.joamit.caresearch.api.commons.domain.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface EngineRepository extends MongoRepository<Engine, String> {
}
