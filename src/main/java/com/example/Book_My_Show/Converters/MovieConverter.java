package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.Entities.MovieEntity;
import com.example.Book_My_Show.EntryDtos.MovieEntryDto;

public class MovieConverter  {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity=MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage())
                .ganer(movieEntryDto.getGaner())
                .build();
        return movieEntity;
    }
}
