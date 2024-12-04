package com.Evenement.CrudWithMongoDB.Services.Notification;

import com.Evenement.CrudWithMongoDB.Dtos.NotificationDto;
import com.Evenement.CrudWithMongoDB.Entities.Notification;
import com.Evenement.CrudWithMongoDB.Mappers.NotificationMapper;
import com.Evenement.CrudWithMongoDB.Repositories.NotificationRepository;
import com.Evenement.CrudWithMongoDB.Utils.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImp implements NotificationService{

    private final NotificationRepository notificationRepository;
    private final NotificationMapper mapper;
    private final EmailService emailService;

    @Override
    public NotificationDto add(Notification notification) {
        return mapper.toDto(notificationRepository.save(notification));
    }

    @Override
    public List<NotificationDto> notifications() {
        return mapper.toDto(notificationRepository.findAll());
    }

    @Override
    public List<NotificationDto> sentNotifications() {
        return mapper.toDto(notificationRepository.findBySentTrue());
    }

    @Override
    public List<NotificationDto> notSentNotifications() {
        return mapper.toDto(notificationRepository.findBySentFalse());
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void sendNotification() {
        List<Notification> notifications = notificationRepository.findBySentFalse();
        if (notifications.isEmpty()) {
            System.out.println("notifications is empty");
            return;
        }
        log.info(notifications.toString());
        Context context = new Context();
        notifications.forEach(
            notification -> {
                if(notification.getSendAt().truncatedTo(ChronoUnit.MINUTES)
                        .isEqual(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))){
                    log.info("condition verified");
                    context.setVariable("guestName", notification.getGuest().getName());
                    context.setVariable("eventName", notification.getEventName());
                    context.setVariable("eventDate", notification.getSendAt().toLocalDate().toString());
                    context.setVariable("eventDateTime", String.format("%02d:%02d",
                            notification.getSendAt().getHour(),notification.getSendAt().getMinute()+5));
                    try {
                        emailService.sendEmail(notification.getGuest().getEmail(),context,
                                "Reminder: Event Scheduled for Tomorrow","email");
                        notification.setSent(true);
                        notificationRepository.save(notification);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        );
    }
}
