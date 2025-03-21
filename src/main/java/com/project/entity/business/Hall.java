package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "t_hall")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_primary_id")
    private Long hallId;

    @NotBlank(message = "Hall name cannot be Blank!")
    private String hallName;

    @NotNull(message = "Seat capacity cannot be null")
    @PositiveOrZero(message = "Seat capacity must be positive or zero")
    private Integer seatCapacity;

    @NotNull(message = "Special status cannot be null")
    private Boolean isSpecial;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cinema cinema;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

}
