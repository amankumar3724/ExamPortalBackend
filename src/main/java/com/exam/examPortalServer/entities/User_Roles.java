package com.exam.examPortalServer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class User_Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    //user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //Role
    @ManyToOne
    private Role role;

}
