package com.example.Book_My_Show.Entities;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theators")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;


    // mapping
    // theator is parent for theatorSeat;
    @OneToMany(mappedBy = "theatorEntity",cascade = CascadeType.ALL)
    private List<TheatorSeatEntity>theatorSeatEntityList=new ArrayList<>();


    // theator is parent for show
    @OneToMany(mappedBy = "theatorEntity",cascade = CascadeType.ALL)
    private List<ShowEntity>showEntityList=new ArrayList<>();






}


