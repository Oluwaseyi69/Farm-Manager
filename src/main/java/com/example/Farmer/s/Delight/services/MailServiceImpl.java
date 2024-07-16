package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.config.AppConfig;
import com.example.Farmer.s.Delight.dtos.request.MailRequest;
import com.example.Farmer.s.Delight.dtos.response.SendMailResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@AllArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {
    private final RestTemplate restTemplate;
    private final AppConfig appConfig;
    @Override
    public SendMailResponse sendMail(MailRequest mailRequest) {
            try {
                HttpHeaders headers = addRequestHeaders();
                RequestEntity<MailRequest> requestEntity = new RequestEntity<>(mailRequest, headers, POST, URI.create("https://api.brevo.com/v3/smtp/email"));
                log.info("Sending email with request: {}", mailRequest);

                ResponseEntity<SendMailResponse> mailResponse =
                        restTemplate.postForEntity("https://api.brevo.com/v3/smtp/email", requestEntity,
                                SendMailResponse.class);
                log.info("Mail response: {}", mailResponse);

                if (mailResponse.getBody() == null) {
                    log.error("Failed to send email, no response body received.");
                    throw new RuntimeException("Mail Sending failed, no response body received.");
                }

                log.info("Email sent successfully with response: {}", mailResponse.getBody());
                return buildSendMailResponse(mailResponse);
            } catch (Exception ex) {
                System.out.println(Arrays.toString(ex.getStackTrace()));
                SendMailResponse sendMailResponse = new SendMailResponse();
                sendMailResponse.setMessageId(ex.getMessage());
                return sendMailResponse;
            }

        }

        private HttpHeaders addRequestHeaders() {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(APPLICATION_JSON);
            headers.setAccept(List.of(APPLICATION_JSON));
            headers.set("api-key", appConfig.getMailApiKey());
            return headers;
        }
        private static SendMailResponse buildSendMailResponse(ResponseEntity<SendMailResponse> mailResponse) {
            HttpStatusCode code = mailResponse.getStatusCode();
            SendMailResponse response = mailResponse.getBody();


            if (response == null) {
                throw new RuntimeException("Mail Sending failed, response body is null.");
            }

            response.setStatusCode(code.value());
            return response;        }


    }
