package com.example.Book_My_Show.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Ticket")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  //  private int price;

    private String movieName;

    private LocalDate showDate;
    private LocalTime showTime;

   private int totalAmount;
   private String ticketId= UUID.randomUUID().toString();

   private String theatorName;
    private String bookedSeats;

    // ticket is child for usear;
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    //ticket is childe wrt show entity
    @JoinColumn
    @ManyToOne
    private ShowEntity showEntity;


}
