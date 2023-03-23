package com.example.Book_My_Show.Services;
import com.example.Book_My_Show.Converters.ShowConverter;
import com.example.Book_My_Show.Entities.*;
import com.example.Book_My_Show.EntryDtos.ShowEntityDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Repositorys.MovieRepository;
import com.example.Book_My_Show.Repositorys.ShowRepository;
import com.example.Book_My_Show.Repositorys.TheatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    TheatorRepository theatorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow (ShowEntityDto showEntityDto){

        ShowEntity showEntity= ShowConverter.convertDtoToEntity(showEntityDto);


        int movieId= showEntityDto.getMovieId();
        int theatorId= showEntityDto.getTheatorId();


        MovieEntity movieEntity=movieRepository.findById(movieId).get();
        TheatorEntity theatorEntity=theatorRepository.findById(theatorId).get();



        // setting forigine key Attribute;
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatorEntity(theatorEntity);


        // pending attribute the listOfShowSEatEntity
        List<ShowSeatEntity>actualShowSeat=creatShowSeat(showEntityDto,showEntity);

        // setting accualshowseat to showEntity;
        showEntity.setShowSeatEntityList(actualShowSeat);

        showEntity=showRepository.save(showEntity);

        // now we need to set parent attribute
        // for movie and show movi is parent
        // getting the list of showEntity and adding show in movie
        List<ShowEntity>showEntityList=movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);
        // not saving show because movie is parent for show
        movieRepository.save(movieEntity);


        // for theator and show
        // getting the list of SHowEntity and adding show in theator
        List<ShowEntity>theatorShowEntityList=theatorEntity.getShowEntityList();
        theatorShowEntityList.add(showEntity);
        theatorEntity.setShowEntityList(showEntityList);
        // not saving show because theator is preant for show
        theatorRepository.save(theatorEntity);

        return " show Added Sucessfully";
    }
    private List<ShowSeatEntity>creatShowSeat (ShowEntityDto showEntityDto,ShowEntity showEntity){
        List<ShowSeatEntity>showSeatEntityList=new ArrayList<>();

//        TheatorEntity theatorEntity=theatorRepository.findById(showEntityDto.getTheatorId()).get();
//
//        int noOfSeat=theatorEntity.getTheatorSeatEntityList().size();
//
//        for(int i=1;i<=noOfSeat;i++){
//
//            ShowSeatEntity showSeatEntity= ShowSeatEntity.builder()
//                    .seatNo(theatorEntity.getTheatorSeatEntityList().get(i).getSeatNo())
//                    .seatType(theatorEntity.getTheatorSeatEntityList().get(i).getSeatType())
//                    .showEntity(showEntity)
//                    .build();
//
//            if(theatorEntity.getTheatorSeatEntityList().get(i).getSeatType().equals(SeatType.CLASSIC)){
//
//                showSeatEntity.setSeatPrise(showEntityDto.getClassicPrice());
//            }
//            else {
//                showSeatEntity.setSeatPrise(showEntityDto.getPrimiumPrice());
//            }
//            showSeatEntityList.add(showSeatEntity);
//
//        }

        // upper code is also correct

        TheatorEntity theatorEntity=showEntity.getTheatorEntity();
        List<TheatorSeatEntity>theatorSeatEntityList=theatorEntity.getTheatorSeatEntityList();

        for(TheatorSeatEntity theatorSeatEntity:theatorSeatEntityList){

            ShowSeatEntity showSeatEntity=new ShowSeatEntity();

            showSeatEntity.setSeatNo(theatorSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatorSeatEntity.getSeatType());

            if(theatorSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setSeatPrise(showEntityDto.getClassicPrice());

            else
                showSeatEntity.setSeatPrise(showEntityDto.getPrimiumPrice());


            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);// setting its parent;
            showSeatEntityList.add(showSeatEntity);//adding it to the list
        }

        return showSeatEntityList;

    }
}
