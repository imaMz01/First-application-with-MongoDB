package com.Evenement.CrudWithMongoDB.Repositories;

import com.Evenement.CrudWithMongoDB.Entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {

    List<Notification> findBySentFalse();
    List<Notification> findBySentTrue();

}
