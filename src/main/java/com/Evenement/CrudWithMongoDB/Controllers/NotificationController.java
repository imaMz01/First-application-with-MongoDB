package com.Evenement.CrudWithMongoDB.Controllers;

import com.Evenement.CrudWithMongoDB.Dtos.NotificationDto;
import com.Evenement.CrudWithMongoDB.Services.Notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDto>> notifications(){
        return new ResponseEntity<>(notificationService.notifications(), HttpStatus.OK);
    }

    @GetMapping("/sentNotifications")
    public ResponseEntity<List<NotificationDto>> sentNotifications(){
        return new ResponseEntity<>(notificationService.sentNotifications(), HttpStatus.OK);
    }

    @GetMapping("/notSentNotifications")
    public ResponseEntity<List<NotificationDto>> notSentNotifications(){
        return new ResponseEntity<>(notificationService.notSentNotifications(), HttpStatus.OK);
    }
}
