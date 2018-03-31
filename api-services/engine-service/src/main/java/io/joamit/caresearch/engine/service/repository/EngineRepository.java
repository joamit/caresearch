package io.joamit.caresearch.engine.service.repository;

import io.joamit.caresearch.api.commons.domain.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EngineRepository extends MongoRepository<Engine, String> {
    Optional<Engine> findByName(String name);
}
