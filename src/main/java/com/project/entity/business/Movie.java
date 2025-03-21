package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.enums.MovieStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movied_id")
    private Long movieId;

    @NotNull
    @Size(min = 3,max = 100)
    private String title;

    @NotNull
    @Size(min = 5,max = 20)
    private String slug;

    @NotNull
    @Size(min = 3,max = 20)
    private String summary;

    @NotNull
    private Date releaseDate;

    @NotNull()
    private Integer duration;

    @Nullable
    private Double rating;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @Nullable
    private String specialHalls;

    @NotNull
    private String director;

    @NotNull
    @ElementCollection
    private List<String> cast;

    @NotNull
    @ElementCollection
    private List<String> formats;

    @NotNull
    private String genre;

    @NotNull
    @Column(name = "status", nullable = false, columnDefinition = "INT DEFAULT 0")
    private MovieStatus status;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall> halls;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowTime> showTimes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cinema cinema;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;


}
