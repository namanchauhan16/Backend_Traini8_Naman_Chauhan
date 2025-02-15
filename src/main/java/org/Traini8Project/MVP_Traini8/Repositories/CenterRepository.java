package org.Traini8Project.MVP_Traini8.Repositories;

import org.Traini8Project.MVP_Traini8.Entity.Center;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Training Centre Repository for MongoDB operations
@Repository
public interface CenterRepository extends MongoRepository<Center, String> {
}
