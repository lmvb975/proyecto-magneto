package com.magneto.project.repositories;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.magneto.project.models.entities.Adn;

public interface AdnRepository extends DatastoreRepository<Adn,String> {
}
