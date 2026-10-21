package com.arthur.library_management_api.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDTO {
    @NotBlank
    private String title;
    private String isbn;
    @NotNull
    private Year published_year;
    @NotNull
    private Long authorId;
}
