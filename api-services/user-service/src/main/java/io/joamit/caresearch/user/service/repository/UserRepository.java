package io.joamit.caresearch.user.service.repository;

import io.joamit.caresearch.api.commons.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends MongoRepository<User, String> {
}
