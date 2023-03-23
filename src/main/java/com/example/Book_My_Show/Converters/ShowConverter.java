package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.Entities.ShowEntity;
import com.example.Book_My_Show.EntryDtos.ShowEntityDto;

public class ShowConverter {

    public static ShowEntity convertDtoToEntity(ShowEntityDto showEntityDto){

       ShowEntity showEntity= ShowEntity.builder()
               .showDate(showEntityDto.getShowDate())
               .showTime(showEntityDto.getShowTime())
               .showType(showEntityDto.getShowType())
               .build();

       return showEntity;
    }

}
