package com.example.Book_My_Show.EntryDtos;

import com.example.Book_My_Show.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntityDto {

    private int movieId;
    private int theatorId;
    private int classicPrice;
    private int primiumPrice;
    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;

}
