package com.example.Book_My_Show.Entities;

import com.example.Book_My_Show.Enums.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDate showDate;
    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updateOn;

    // mapping

    // child with rest to movi entity
    @JoinColumn
    @ManyToOne
    private MovieEntity movieEntity;

    // show is child for theator
    @JoinColumn
    @ManyToOne
    private TheatorEntity theatorEntity;

    // show is parent for ticker
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity>ticketEntityList=new ArrayList<>();

    // show is parent for showSeat
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity>showSeatEntityList=new ArrayList<>();





}
