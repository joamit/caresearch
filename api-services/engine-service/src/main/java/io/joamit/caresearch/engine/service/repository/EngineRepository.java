package io.joamit.caresearch.engine.service.repository;

import io.joamit.caresearch.api.commons.domain.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineRepository extends MongoRepository<Engine, String> {
}
