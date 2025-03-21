package com.project.entity.business;

import com.cinetime.cinetime.entity.enums.TicketStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name ="t_ticket")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ticket_id")
        private Long ticketId;

        @Column(nullable = false)
        private String seatLetter;

        @Column(nullable = false)
        private int seatNumeber;

        @Column(nullable = false)
        public Double price;

        @Enumerated(EnumType.STRING)
       private TicketStatus ticketStatus= TicketStatus.Reserved;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MMM-yyyy", timezone = "US")
        @Column(nullable = false)
        private LocalDateTime createdAt;

        @ManyToOne(cascade = CascadeType.PERSIST)
        private User user;

        @OneToOne
        private Payment payment;

        @ManyToOne(cascade = CascadeType.PERSIST)
        private Hall hall;


    }
