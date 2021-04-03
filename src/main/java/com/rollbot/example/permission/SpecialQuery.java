package com.rollbot.example.permission;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public class SpecialQuery {

    @NotNull
    @NotBlank
    private int id;

    private String username;
    private String firstname;
    private String lastname;
}
