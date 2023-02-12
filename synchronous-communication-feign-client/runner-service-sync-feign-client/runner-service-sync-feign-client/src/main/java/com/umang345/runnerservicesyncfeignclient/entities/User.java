package com.umang345.runnerservicesyncfeignclient.entities;
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
