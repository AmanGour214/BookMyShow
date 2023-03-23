package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Converters.TheatorConverter;
import com.example.Book_My_Show.Entities.TheatorEntity;
import com.example.Book_My_Show.Entities.TheatorSeatEntity;
import com.example.Book_My_Show.EntryDtos.TheatorEntryDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Repositorys.TheatorRepository;
import com.example.Book_My_Show.Repositorys.TheatorSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatorService {

    @Autowired
    TheatorRepository theatorRepository;

    @Autowired
    TheatorSeatRepository theatorSeatRepository;

    public String addTheator(TheatorEntryDto theatorEntryDto){

        // convert dto to entity
        // basic attribute are set;
        TheatorEntity theatorEntity= TheatorConverter.convertDtoToEntity(theatorEntryDto);

        // now when theator is created simultaniously theatorSeat should be created;

        List<TheatorSeatEntity>constructedSeat=creatSeats(theatorEntryDto,theatorEntity);
        theatorEntity.setTheatorSeatEntityList(constructedSeat);

        theatorRepository.save(theatorEntity);

        return "Theator created sucessfully ";


    }

    private List<TheatorSeatEntity>creatSeats (TheatorEntryDto theatorEntryDto,TheatorEntity theatorEntity){

        List<TheatorSeatEntity>theatorSeatEntityList=new ArrayList<>();

        int noOfClassicSeat=theatorEntryDto.getClassicSeatCount();
        int noOfPrimiumSeat=theatorEntryDto.getPremiumSeatCount();


        for(int i=1;i<=noOfClassicSeat;i++){

            TheatorSeatEntity theatorSeatEntity=TheatorSeatEntity.builder()
                    .seatType(SeatType.CLASSIC)
                    .seatNo(i+"C")
                    .theatorEntity(theatorEntity)
                    .build();
            theatorSeatEntityList.add(theatorSeatEntity);
        }


        for(int i=1;i<=noOfPrimiumSeat;i++){

            TheatorSeatEntity theatorSeatEntity=TheatorSeatEntity.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNo(i+"P")
                    .theatorEntity(theatorEntity)
                    .build();
            theatorSeatEntityList.add(theatorSeatEntity);
        }

        // now we dont need to save theatorSeat because on line 36 we are saving its
        // parent theatorEntity.
        //theatorSeatRepository.saveAll(theatorSeatEntityList);


        return theatorSeatEntityList;

    }

}
