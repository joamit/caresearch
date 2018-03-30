package io.joamit.caresearch.media.service.repository;

import io.joamit.caresearch.api.commons.domain.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface MediaRepository extends MongoRepository<Media, String> {
}
