package com.Evenement.CrudWithMongoDB.Controllers;

import com.Evenement.CrudWithMongoDB.Dtos.EventDto;
import com.Evenement.CrudWithMongoDB.Services.Event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/addEvent")
    public ResponseEntity<EventDto> add(@RequestBody EventDto eventDto){
        return new ResponseEntity<>(eventService.add(eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> events(){
        return new ResponseEntity<>(eventService.allEvents(),HttpStatus.OK);
    }

    @GetMapping("/EventById/{id}")
    public ResponseEntity<EventDto> EventById(@PathVariable String id){
        return new ResponseEntity<>(eventService.eventById(id),HttpStatus.OK);
    }

    @PutMapping("/updateEvent/")
    public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto){
        return new ResponseEntity<>(eventService.updateEvent(eventDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id){
        return new ResponseEntity<>(eventService.deleteEvent(id),HttpStatus.OK);
    }
}
