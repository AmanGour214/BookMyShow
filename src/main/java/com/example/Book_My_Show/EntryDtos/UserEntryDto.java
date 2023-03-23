package com.example.Book_My_Show.EntryDtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserEntryDto {

    private String name;
     private String email;

    private int age;
    private String address;
    private String moblileNo;
}
