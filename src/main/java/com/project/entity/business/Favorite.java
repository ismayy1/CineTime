package com.project.entity.business;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Entity(name = "t_favorite")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long favoriteId;

    //User Relation
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;


    // Movie Relation
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;

   // Cinema Relation
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cinema cinema;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;


}
