package ru.netology.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.rest.authorities.Authorities;
import ru.netology.rest.exceptions.InvalidCredentials;
import ru.netology.rest.exceptions.UnauthorizedUser;
import ru.netology.rest.model.LoginUser;
import ru.netology.rest.model.User;
import ru.netology.rest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping(value="/authorize")
    public List<Authorities> getAuthorities(@Valid @LoginUser User user) {
        return service.getAuthorities(user);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials (InvalidCredentials e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>( "Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser (UnauthorizedUser e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
