package com.example.Book_My_Show.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @Column(unique = true,nullable = false)
    private String email;

    private int age;

    @Column(unique = true,nullable = false)
    private String moblileNo;

    private String address;



    //Mapping
    // user is parent for ticket;
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<TicketEntity>bookedTickets=new ArrayList<>();




}
