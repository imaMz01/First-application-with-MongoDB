package com.Evenement.CrudWithMongoDB.Mappers;

import com.Evenement.CrudWithMongoDB.Dtos.NotificationDto;
import com.Evenement.CrudWithMongoDB.Entities.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto toDto(Notification role);
    Notification toEntity(NotificationDto roleDto);
    List<NotificationDto> toDto(List<Notification> role);
    List<Notification> toEntity(List<NotificationDto> roleDto);
}
