package com.umang345.userserviceasyncrabbitmq.entities;

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
