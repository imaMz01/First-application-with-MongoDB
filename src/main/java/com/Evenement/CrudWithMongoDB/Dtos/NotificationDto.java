package com.Evenement.CrudWithMongoDB.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationDto {

    private String id;
    private GuestDto guest;
    private String eventName;
    private LocalDateTime sendAt;
    private Boolean sent;
}
