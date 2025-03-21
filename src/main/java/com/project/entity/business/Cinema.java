package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "t_cinema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long cinemaId;

    @NotNull(message = "Cinema name cannot be null")
    private String cinemaName;
/*
    @NotNull(message = "Cinema address cannot be null")
    @OneToOne(mappedBy = "t_cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address cinemaAddress;
 */

    @NotNull
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall> cinemaHall;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;

    @NotNull
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movie> cinemaMovie;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime cinemaCreatedAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;





}
