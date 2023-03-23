package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.Entities.UserEntity;
import com.example.Book_My_Show.EntryDtos.UserEntryDto;

public class UserConverter {

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        UserEntity  userEntity=UserEntity.builder().age(userEntryDto.getAge())
                .name(userEntryDto.getName())
                .moblileNo(userEntryDto.getMoblileNo())
                .email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress())
                .build();
        return userEntity;
    }
}
