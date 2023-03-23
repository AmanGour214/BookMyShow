package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDtos.TheatorEntryDto;
import com.example.Book_My_Show.Services.TheatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theaators")
public class TheatorController {

    @Autowired
    TheatorService theatorService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheator(@RequestBody TheatorEntryDto theatorEntryDto){

        try {
            String response=theatorService.addTheator(theatorEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


}
