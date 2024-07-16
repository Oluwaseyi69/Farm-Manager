package com.example.Farmer.s.Delight.dtos.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class MailRequest {
    private Sender sender;
    private List<Receiver> to;
    private String subject;
    private String htmlContent;
}
