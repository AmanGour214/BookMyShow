package com.example.Book_My_Show.Entities;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ShowSeats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private int seatPrise;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;



    private Date bookedAt;

    // mapping
    // ShowSeatEntity is child for SHOW
    @JoinColumn
    @ManyToOne
    private ShowEntity showEntity;
}
