package com.Evenement.CrudWithMongoDB.Dtos;

import com.Evenement.CrudWithMongoDB.Entities.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GuestDto {

    private String id;
    private String name;
    private String email;
    private String tel;
    private List<EventDto> events = new ArrayList<>();
}
