package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Converters.UserConverter;
import com.example.Book_My_Show.Entities.UserEntity;
import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto)throws Exception,NullPointerException{

        UserEntity userEntity= UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User added Success fully";


    }

}
