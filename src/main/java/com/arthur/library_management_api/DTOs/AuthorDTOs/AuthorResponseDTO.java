package com.arthur.library_management_api.DTOs.AuthorDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String email;
}
