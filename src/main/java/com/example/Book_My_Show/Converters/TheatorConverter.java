package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.Entities.TheatorEntity;
import com.example.Book_My_Show.EntryDtos.TheatorEntryDto;

public class TheatorConverter {
    // we are converting dtos to entity;
    public static TheatorEntity convertDtoToEntity(TheatorEntryDto theatorEntryDto){

        TheatorEntity theatorEntity= TheatorEntity.builder()
                .name(theatorEntryDto.getName())
                .location(theatorEntryDto.getLocation())
                .build();
        return theatorEntity;

    }

}
