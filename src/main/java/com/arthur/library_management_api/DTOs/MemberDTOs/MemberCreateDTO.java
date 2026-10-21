package com.arthur.library_management_api.DTOs.MemberDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberCreateDTO {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
}
