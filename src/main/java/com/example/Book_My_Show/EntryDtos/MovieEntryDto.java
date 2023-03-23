package com.example.Book_My_Show.EntryDtos;

import com.example.Book_My_Show.Enums.Ganer;
import com.example.Book_My_Show.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;

    private int duration;
    private double rating;


    private Language language;


    private Ganer ganer;
}
