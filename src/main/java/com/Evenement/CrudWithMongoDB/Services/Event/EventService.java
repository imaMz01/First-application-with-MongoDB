package com.Evenement.CrudWithMongoDB.Services.Event;

import com.Evenement.CrudWithMongoDB.Dtos.EventDto;

import java.util.List;

public interface EventService {

    EventDto add(EventDto eventDto);
    List<EventDto> allEvents();
    EventDto eventById(String id);
    EventDto updateEvent(EventDto eventDto);
    String deleteEvent(String id);
}
