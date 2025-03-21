package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "t_showTimes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showTime_id")
    private Long showTimeId;

    @NotNull(message = "Date cannot be null")
    @DateTimeFormat(pattern = "mm-yyyy")
    private LocalDate showTimeDate;

    @NotNull(message = "Start time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotNull(message = "End time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime showTimeCreatedAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;


}
