package com.example.Book_My_Show.Repositorys;

import com.example.Book_My_Show.Entities.TheatorSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatorSeatRepository extends JpaRepository<TheatorSeatEntity , Integer> {

}
