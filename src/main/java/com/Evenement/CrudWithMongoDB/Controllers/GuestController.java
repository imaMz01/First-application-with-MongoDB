package com.Evenement.CrudWithMongoDB.Controllers;


import com.Evenement.CrudWithMongoDB.Dtos.GuestDto;
import com.Evenement.CrudWithMongoDB.Services.Guest.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping("/addGuest")
    public ResponseEntity<GuestDto> add(@RequestBody GuestDto eventDto){
        return new ResponseEntity<>(guestService.add(eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/guests")
    public ResponseEntity<List<GuestDto>> events(){
        return new ResponseEntity<>(guestService.allGuests(),HttpStatus.OK);
    }

    @GetMapping("/guestById/{id}")
    public ResponseEntity<GuestDto> EventById(@PathVariable String id){
        return new ResponseEntity<>(guestService.guestById(id),HttpStatus.OK);
    }

    @PutMapping("/updateGuest/")
    public ResponseEntity<GuestDto> updateEvent(@RequestBody GuestDto eventDto){
        return new ResponseEntity<>(guestService.updateGuest(eventDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteGuest/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id){
        return new ResponseEntity<>(guestService.deleteGuest(id),HttpStatus.OK);
    }

    @GetMapping("/addEventToGuest/{idGuest}/{idEvent}")
    public ResponseEntity<GuestDto> addEventToGuest(@PathVariable String idGuest, @PathVariable String idEvent){
        return new ResponseEntity<>(guestService.addEventToGuest(idEvent,idGuest),HttpStatus.OK);
    }
}
