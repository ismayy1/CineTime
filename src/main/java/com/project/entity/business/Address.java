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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotBlank(message = "Country name cannot be Blank!")
    private String countryName;

    @NotBlank(message = "City name cannot be Blank!")
    private String cityName;

    @NotBlank(message = "District name cannot be Blank!")
    private String districtName;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @OneToOne
    private Cinema cinema;

}
