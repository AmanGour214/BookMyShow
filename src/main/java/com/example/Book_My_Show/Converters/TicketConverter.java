package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.Entities.TicketEntity;
import com.example.Book_My_Show.EntryDtos.TicketEntryDto;

public class TicketConverter {

    public static TicketEntity convertDtoToEntity (TicketEntryDto ticketEntryDto){

        TicketEntity ticketEntity=new TicketEntity();
        return ticketEntity;
    }
}
