package com.Evenement.CrudWithMongoDB.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Event {

    @Id
    private String id;
    private String name;
    private String city;
    private int placeNumber;
    private LocalDateTime date;
}
