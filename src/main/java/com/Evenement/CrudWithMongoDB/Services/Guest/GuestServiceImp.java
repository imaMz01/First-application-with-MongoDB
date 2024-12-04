package com.Evenement.CrudWithMongoDB.Services.Guest;

import com.Evenement.CrudWithMongoDB.Dtos.EventDto;
import com.Evenement.CrudWithMongoDB.Dtos.GuestDto;
import com.Evenement.CrudWithMongoDB.Entities.Event;
import com.Evenement.CrudWithMongoDB.Entities.Guest;
import com.Evenement.CrudWithMongoDB.Entities.Notification;
import com.Evenement.CrudWithMongoDB.Exceptions.GuestNotFoundException;
import com.Evenement.CrudWithMongoDB.Mappers.EventMapper;
import com.Evenement.CrudWithMongoDB.Mappers.GuestMapper;
import com.Evenement.CrudWithMongoDB.Repositories.GuestRepository;
import com.Evenement.CrudWithMongoDB.Services.Event.EventService;
import com.Evenement.CrudWithMongoDB.Services.Notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuestServiceImp implements GuestService{

    private final GuestMapper mapper;
    private final EventMapper eventMapper;
    private final GuestRepository guestRepository;
    private final EventService eventService;
    private final NotificationService notificationService;

    @Override
    public GuestDto add(GuestDto guestDto) {
        Guest guest = mapper.toEntity(guestDto);
        guest.setId(UUID.randomUUID().toString());
        return mapper.toDto(guestRepository.save(guest));
    }

    @Override
    public List<GuestDto> allGuests() {
        return  mapper.toDto(guestRepository.findAll());
    }
    public Guest getById(String id){
        return guestRepository.findById(id).orElseThrow(
                GuestNotFoundException::new
        );
    }

    @Override
    public GuestDto guestById(String id) {
        return mapper.toDto(
                guestRepository.findById(id).orElseThrow(
                        GuestNotFoundException::new
                )
        );
    }

    @Override
    public GuestDto updateGuest(GuestDto guestDto) {
        Guest guest = getById(guestDto.getId());
        guest.setName(guestDto.getName());
        guest.setTel(guestDto.getTel());
        guest.setEmail(guestDto.getEmail());
        return mapper.toDto(guestRepository.save(guest));
    }

    @Override
    public String deleteGuest(String id) {
        Guest guest = getById(id);
        guestRepository.delete(guest);
        return "Event was deleted successfully";
    }

    @Override
    @Transactional
    public GuestDto addEventToGuest(String idEvent, String idGuest) {
        Guest guest = getById(idGuest);
        notificationService.add(new Notification(UUID.randomUUID().toString(),guest,
                eventService.eventById(idEvent).getName(),
                eventService.eventById(idEvent).getDate().minusMinutes(5),false));
        guest.getEvents().add(eventMapper.toEntity(eventService.eventById(idEvent)));
        return mapper.toDto(guestRepository.save(guest));
    }
}
