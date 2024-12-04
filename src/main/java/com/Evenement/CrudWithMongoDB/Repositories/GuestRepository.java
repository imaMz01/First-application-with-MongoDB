package com.Evenement.CrudWithMongoDB.Repositories;

import com.Evenement.CrudWithMongoDB.Entities.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends MongoRepository<Guest,String> {
}
