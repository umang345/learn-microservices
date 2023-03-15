package com.umang345.consul.runnerservice.entities;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User
{
    long id;
    String firstName;
    String lastName;
    String email;
}
