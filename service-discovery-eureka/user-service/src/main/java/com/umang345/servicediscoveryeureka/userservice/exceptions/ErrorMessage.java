package com.umang345.servicediscoveryeureka.userservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage
{
    private String message;
    private String details;
}
