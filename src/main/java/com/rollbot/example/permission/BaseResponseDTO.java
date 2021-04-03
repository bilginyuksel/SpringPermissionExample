package com.rollbot.example.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BaseResponseDTO {
    private String returnCode;
    private String returnDesc;
}
