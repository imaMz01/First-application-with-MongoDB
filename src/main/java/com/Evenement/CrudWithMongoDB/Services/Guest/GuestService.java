package com.Evenement.CrudWithMongoDB.Services.Guest;

import com.Evenement.CrudWithMongoDB.Dtos.GuestDto;

import java.util.List;

public interface GuestService {

    GuestDto add(GuestDto guestDto);
    List<GuestDto> allGuests();
    GuestDto guestById(String id);
    GuestDto updateGuest(GuestDto guestDto);
    String deleteGuest(String id);
    GuestDto addEventToGuest(String idEvent,String idGuest);
}
