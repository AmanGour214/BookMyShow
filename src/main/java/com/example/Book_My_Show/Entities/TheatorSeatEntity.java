package com.example.Book_My_Show.Entities;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TheatorSeat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatorSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private String  seatNo;



    // mappping
    // theatorSeat is child for theator

    @ManyToOne
    @JoinColumn
    private TheatorEntity theatorEntity;


}
