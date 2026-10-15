package com.arthur.library_management_api.DTOs;

import com.arthur.library_management_api.Entities.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String email;
}
