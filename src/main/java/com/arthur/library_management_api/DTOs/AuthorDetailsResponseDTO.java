package com.arthur.library_management_api.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDetailsResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<BookSummaryDTO> books;
}
