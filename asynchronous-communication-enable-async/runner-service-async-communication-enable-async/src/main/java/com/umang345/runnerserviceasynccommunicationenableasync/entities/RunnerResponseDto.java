package com.umang345.runnerserviceasynccommunicationenableasync.entities;

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
