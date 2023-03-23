package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movies")
public class MovieConroller {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")

    public ResponseEntity<String> creatMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{
            String response =movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            String result="movie Not Added";
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }


    }
}
