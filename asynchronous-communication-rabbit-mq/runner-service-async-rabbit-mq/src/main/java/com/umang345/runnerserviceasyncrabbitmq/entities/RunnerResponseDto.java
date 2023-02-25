package com.umang345.runnerserviceasyncrabbitmq.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RunnerResponseDto
{
    User user;
    String message;
}
