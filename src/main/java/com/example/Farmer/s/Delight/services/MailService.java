package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.dtos.request.MailRequest;
import com.example.Farmer.s.Delight.dtos.response.SendMailResponse;

public interface MailService {
    SendMailResponse sendMail(MailRequest mailRequest);
}
