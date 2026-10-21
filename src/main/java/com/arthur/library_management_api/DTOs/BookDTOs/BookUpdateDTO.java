package com.arthur.library_management_api.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class BookUpdateDTO {
    @NotBlank
    private String title;
    private String isbn;
    @NotNull
    private Year published_year;
    @NotNull
    private Long authorId;
}
