package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "t_payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @NotNull(message = "Payment can not be null")
    @Column(name = "amount")
    private Double amount;

    @NotNull(message = "Payment Status must not be empty")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;


    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;




}
