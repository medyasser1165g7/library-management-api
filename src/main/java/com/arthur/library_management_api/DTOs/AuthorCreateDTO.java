package com.arthur.library_management_api.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
