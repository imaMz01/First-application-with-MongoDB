package com.Evenement.CrudWithMongoDB.Repositories;

import com.Evenement.CrudWithMongoDB.Entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event,String> {
}
