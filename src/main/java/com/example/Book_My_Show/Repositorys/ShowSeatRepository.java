package com.example.Book_My_Show.Repositorys;

import com.example.Book_My_Show.Entities.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
