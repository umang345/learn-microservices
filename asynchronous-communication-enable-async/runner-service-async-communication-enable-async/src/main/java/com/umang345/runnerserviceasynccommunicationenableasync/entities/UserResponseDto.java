package com.umang345.runnerserviceasynccommunicationenableasync.entities;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto
{
    Integer status;
    User data;
}
