package com.Evenement.CrudWithMongoDB.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {

    private String id;
    @NotNull(message = "Name should be not null")
    @NotEmpty(message = "Name should be not empty")
    private String name;
    @NotNull(message = "City should be not null")
    @NotEmpty(message = "City should be not empty")
    private String city;
    @NotNull(message = "Place number should be not null")
    @NotEmpty(message = "Place number should be not empty")
    private int placeNumber;
    @NotNull(message = "Date should be not null")
    @NotEmpty(message = "Date should be not empty")
    private LocalDateTime date;
}
