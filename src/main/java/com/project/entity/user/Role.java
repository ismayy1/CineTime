package com.project.entity.user;



import com.project.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Enumerated(EnumType.STRING)
   private RoleType roleType;

   @OneToMany(mappedBy = "role")
   private List<User> user;

   public Role(RoleType roleType){this.roleType =roleType;}
}
