package com.project.entity.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.business.Favorite;
import com.project.entity.business.Ticket;
import com.project.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "t_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name="builtIn")
    private Boolean builtIn = false;

    @Column(name = "phone_number")
    private String phoneNumber;


    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @Column(nullable = false, name = "reset_passwort_code")
    private String resetPasswordCode;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;


}
