package com.umang345.userserviceasynccommunicationenableasync.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponseDto
{
    Integer status;
    User data;
}
