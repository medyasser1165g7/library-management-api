package com.arthur.library_management_api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter

public class BookResponseDTO {
    private Long id;
    private String title;
    private String isbn;
    private Year published_year;
    private Boolean available;
    private AuthorResponseDTO authorResponseDTO;
}
