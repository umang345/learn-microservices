package com.umang345.mailserviceasyncrabbitmq.entities;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserMailQueueMessage
{
    private String mailQueueMessageId;
    private User userMessage;
    private Date queueMessageDate;
}
