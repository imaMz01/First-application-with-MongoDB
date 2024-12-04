package com.Evenement.CrudWithMongoDB.Mappers;

import com.Evenement.CrudWithMongoDB.Dtos.GuestDto;
import com.Evenement.CrudWithMongoDB.Entities.Guest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestDto toDto(Guest role);
    Guest toEntity(GuestDto roleDto);
    List<GuestDto> toDto(List<Guest> role);
    List<Guest> toEntity(List<GuestDto> roleDto);
}
