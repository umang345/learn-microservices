package com.umang345.userserviceasynccommunicationenableasync.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String firstName;

    String lastName;

    String email;
}
