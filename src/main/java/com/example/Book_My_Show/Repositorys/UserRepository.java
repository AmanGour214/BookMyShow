package com.example.Book_My_Show.Repositorys;

import com.example.Book_My_Show.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer > {
}
