    package com.example.Book_My_Show.Entities;

    import com.example.Book_My_Show.Enums.Ganer;
    import com.example.Book_My_Show.Enums.Language;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "Movies")
    @Data
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
public class MovieEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(unique = true,nullable = false)
        private String movieName;

        private int duration;
        private double rating;

        @Enumerated(value = EnumType.STRING)
        private Language language;

        @Enumerated(value = EnumType.STRING)
        private Ganer ganer;

        // mapping
        // movie is parent wrt show

        @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
        private List<ShowEntity>showEntityList=new ArrayList<>();







}
