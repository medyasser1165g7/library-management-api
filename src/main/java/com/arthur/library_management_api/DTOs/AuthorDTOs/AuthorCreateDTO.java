package com.arthur.library_management_api.DTOs.AuthorDTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorCreateDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
}
