package com.example.Book_My_Show.EntryDtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {

    private List<String>requestedSeat=new ArrayList<>();
    private int userId;
    private int showId;

}
