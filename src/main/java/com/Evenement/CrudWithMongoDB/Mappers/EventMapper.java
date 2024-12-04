package com.Evenement.CrudWithMongoDB.Mappers;

import com.Evenement.CrudWithMongoDB.Dtos.EventDto;
import com.Evenement.CrudWithMongoDB.Entities.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto toDto(Event role);
    Event toEntity(EventDto roleDto);
    List<EventDto> toDto(List<Event> role);
    List<Event> toEntity(List<EventDto> roleDto);
}
