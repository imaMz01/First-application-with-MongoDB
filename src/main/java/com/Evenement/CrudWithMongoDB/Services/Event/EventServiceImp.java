package com.Evenement.CrudWithMongoDB.Services.Event;

import com.Evenement.CrudWithMongoDB.Dtos.EventDto;
import com.Evenement.CrudWithMongoDB.Entities.Event;
import com.Evenement.CrudWithMongoDB.Exceptions.EventNotFoundException;
import com.Evenement.CrudWithMongoDB.Mappers.EventMapper;
import com.Evenement.CrudWithMongoDB.Repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImp implements EventService {

    private final EventMapper mapper;
    private final EventRepository eventRepository;

    @Override
    public EventDto add(EventDto eventDto) {
        Event event = mapper.toEntity(eventDto);
        event.setId(UUID.randomUUID().toString());
        return mapper.toDto(eventRepository.save(event));
    }

    @Override
    public List<EventDto> allEvents() {
        return mapper.toDto(eventRepository.findAll());
    }

    public Event getById(String id){
        return eventRepository.findById(id).orElseThrow(
                EventNotFoundException::new
        );
    }

    @Override
    public EventDto eventById(String id) {
        return mapper.toDto(eventRepository.findById(id).orElseThrow(
                EventNotFoundException::new
        ));
    }

    @Override
    public EventDto updateEvent(EventDto eventDto) {
        Event event = getById(eventDto.getId());
        event.setCity(eventDto.getCity());
        event.setDate(eventDto.getDate());
        event.setName(eventDto.getName());
        event.setPlaceNumber(eventDto.getPlaceNumber());
        return mapper.toDto(eventRepository.save(event));
    }

    @Override
    public String deleteEvent(String id) {
        Event event = getById(id);
        eventRepository.delete(event);
        return "Event was deleted successfully";
    }
}
