package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDtos.ShowEntityDto;
import com.example.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> creatShow(@RequestBody ShowEntityDto showEntityDto){
        try {
            String response=showService.addShow(showEntityDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
