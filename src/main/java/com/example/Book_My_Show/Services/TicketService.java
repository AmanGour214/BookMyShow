package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Converters.TicketConverter;
import com.example.Book_My_Show.Entities.ShowEntity;
import com.example.Book_My_Show.Entities.ShowSeatEntity;
import com.example.Book_My_Show.Entities.TicketEntity;
import com.example.Book_My_Show.Entities.UserEntity;
import com.example.Book_My_Show.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show.Repositorys.ShowRepository;
import com.example.Book_My_Show.Repositorys.TicketRepository;
import com.example.Book_My_Show.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception{

        TicketEntity ticketEntity= TicketConverter.convertDtoToEntity(ticketEntryDto);

        // checking for requesting seat is avaliable or not;
        boolean isAvaliable=checkAvaliableSeat(ticketEntryDto);

        if(isAvaliable==false){
            throw new Exception("Requested seats are Already Booked");
        }

        // we are here then we can say tha all the seats are avaliable
        // we calculatting the totalAmount

        int showId= ticketEntryDto.getShowId();
        ShowEntity showEntity=showRepository.findById(showId).get();
        List<String>requestedSeats=ticketEntryDto.getRequestedSeat();
        List<ShowSeatEntity>listOfSeats=showEntity.getShowSeatEntityList();


        int totalAnount=0;

        for(ShowSeatEntity showSeatEntity : listOfSeats){

            String seatNo=showSeatEntity.getSeatNo();
            if(requestedSeats.contains(seatNo)){
                totalAnount=totalAnount+showSeatEntity.getSeatPrise();

                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }


        ticketEntity.setTotalAmount(totalAnount);

        // setting all basic attributes and forigine key
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheatorName(showEntity.getTheatorEntity().getName());

        // setting list of Requested seat
        String allotedSeats=getAllotedSeatfromShowSeat(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);

        // setting the forigin key
        UserEntity userEntity=userRepository.findById(ticketEntryDto.getUserId()).get();


        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        ticketEntity=ticketRepository.save(ticketEntity);

        // we need to set the parent attribute;
        List<TicketEntity>ticketEntityList=userEntity.getBookedTickets();
        ticketEntityList.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList);

        userRepository.save(userEntity);

        // for show

        List<TicketEntity>ticketEntityList1=showEntity.getTicketEntityList();
        ticketEntityList1.add(ticketEntity);
        showEntity.setTicketEntityList(ticketEntityList1);
        showRepository.save(showEntity);


        return " ticket added Successfully";

    }

    private String getAllotedSeatfromShowSeat(List<String>RequestedSeats){

        String result="";

        for(String seats  : RequestedSeats){

            result=result+seats+",";
        }
        return result;
    }
    private boolean checkAvaliableSeat (TicketEntryDto ticketEntryDto){

        int showId= ticketEntryDto.getShowId();
        ShowEntity showEntity=showRepository.findById(showId).get();

        // requested seat
        List<String>requestedSeats=ticketEntryDto.getRequestedSeat();

        // getting list of showSeatEntity because we need to check for avaliablity of requested seat;
        List<ShowSeatEntity>listOfSeats=showEntity.getShowSeatEntityList();

        for(ShowSeatEntity showSeatEntity:listOfSeats){
            String seatNo=showSeatEntity.getSeatNo();

            if(requestedSeats.contains(seatNo)){

                if(showSeatEntity.isBooked()==true){
                    return false;
                }
            }

        }
        return true;
    }

}
