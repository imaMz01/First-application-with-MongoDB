package com.Evenement.CrudWithMongoDB.Services.Notification;

import com.Evenement.CrudWithMongoDB.Dtos.NotificationDto;
import com.Evenement.CrudWithMongoDB.Entities.Notification;

import java.util.List;

public interface NotificationService {

    NotificationDto add(Notification notification);
    List<NotificationDto> notifications();
    List<NotificationDto> sentNotifications();
    List<NotificationDto> notSentNotifications();
    void sendNotification();


}
