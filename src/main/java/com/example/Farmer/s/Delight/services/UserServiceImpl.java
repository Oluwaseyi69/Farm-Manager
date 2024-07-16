package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Role;
import com.example.Farmer.s.Delight.data.model.User;
import com.example.Farmer.s.Delight.data.repository.UserRepository;
import com.example.Farmer.s.Delight.dtos.request.*;
import com.example.Farmer.s.Delight.dtos.response.LoginResponse;
import com.example.Farmer.s.Delight.dtos.response.RegisterUserResponse;
import com.example.Farmer.s.Delight.exception.IncorrectCredentialsEx;
import com.example.Farmer.s.Delight.exception.UserAlreadyExistException;
import com.example.Farmer.s.Delight.exception.UserNotFound;
import com.example.Farmer.s.Delight.security.services.JwtServiceImpl;
import com.example.Farmer.s.Delight.utils.EmailTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.Farmer.s.Delight.utils.ExceptionTemplates.*;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;
    private final AuthenticationProvider authenticationProvider;
    private final MailService mailService;

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        checkForUniqueRegistration(registerUserRequest);
        Role role = registerUserRequest.getRole() != null ? registerUserRequest.getRole() : Role.USER;


        User registeredUser = User.builder()
                    .username(registerUserRequest.getUsername())
                    .email(registerUserRequest.getEmail())
                    .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                    .role(role)
                    .build();

        User savedUser= userRepository.save(registeredUser);
        MailRequest sendMailRequest = buildEmailRequest(savedUser);
        mailService.sendMail(sendMailRequest);
        log.info(savedUser.toString());
        log.info("User registered successfully: {}", savedUser);



        String jwtToken = jwtService.generateToken( registeredUser);
        return RegisterUserResponse.builder()
                .email(registeredUser.getEmail())
                .token(jwtToken)
                .message(SUCCESSFULLY_REGISTERED)
                .registerDate(LocalDate.now())
                .build();
    }
    private static MailRequest buildEmailRequest(User user) {
        MailRequest sendEmailRequest = new MailRequest();
        Receiver receiver = new Receiver(user.getFirstName() + user.getLastName(), user.getEmail());
        sendEmailRequest.setTo(List.of(receiver));
        sendEmailRequest.setSubject("Account Created Successfully for " + user.getUsername() );
        sendEmailRequest.setHtmlContent(EmailTemplate.createWelcomeMessageFor(user.getFirstName()));
        Sender sender = new Sender();
        sender.setName("DakAgro");
        sender.setEmail("dakagrolimited@gmail.com");
        sendEmailRequest.setSender(sender);
        return sendEmailRequest;
    }
    private void checkForUniqueRegistration(RegisterUserRequest registerUserRequest) {
        Optional<User> userByUsername = userRepository.findUserByUsername(registerUserRequest.getUsername());
        if (userByUsername.isPresent()) {
            throw new UserAlreadyExistException(USER_ALREADY_EXISTS);
        }

        Optional<User> userByEmail = userRepository.findUserByEmail(registerUserRequest.getEmail());
        if (userByEmail.isPresent()) {
            throw new UserAlreadyExistException(EMAIL_ALREADY_EXISTS);
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            User user = userRepository.findUserByUsername(loginRequest.getUsername()).orElse(null);
            if (user == null) {
                return null;
            }

            String jwtToken = jwtService.generateToken( user);

            return LoginResponse.builder()
                    .token(jwtToken)
                    .message(SUCCESSFULLY_LOGIN)
                    .build();
        } catch (AuthenticationException e) {
            return LoginResponse.builder().message( e.getMessage()).build();
        }
    }


}
