package ru.netology.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
public class User {

    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9-_\\.]{3,12}$", message =" не верный формат")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9]+", message =" не верный формат")
    private String password;

}