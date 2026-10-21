package com.arthur.library_management_api.Mappers;

import com.arthur.library_management_api.DTOs.AuthorDTOs.AuthorCreateDTO;
import com.arthur.library_management_api.DTOs.AuthorDTOs.AuthorDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorDTOs.AuthorResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorDTOs.AuthorUpdateDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookSummaryDTO;
import com.arthur.library_management_api.Entities.Author;
import com.arthur.library_management_api.Entities.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AuthorMapper {
    private final BookMapper bookMapper;

    public Author toEntity(AuthorCreateDTO dto){
        Author author = new Author();
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        return author;
    }
    public AuthorResponseDTO toAuthorResponseDTO(Author author){
        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();
        authorResponseDTO.setId(author.getId());
        authorResponseDTO.setName(author.getName());
        authorResponseDTO.setEmail(author.getEmail());
        return authorResponseDTO;
    }
    public AuthorDetailsResponseDTO toAuthorDetailsResponseDTO(Author author){
        AuthorDetailsResponseDTO authorDetailsResponseDTO = new AuthorDetailsResponseDTO();
        authorDetailsResponseDTO.setId(author.getId());
        authorDetailsResponseDTO.setName(author.getName());
        authorDetailsResponseDTO.setEmail(author.getEmail());
        List<BookSummaryDTO> books = new ArrayList<>();
        for(Book book: author.getBooks()){
            books.add(bookMapper.toBookSummaryDTO(book));
        }
        authorDetailsResponseDTO.setBooks(books);

        return authorDetailsResponseDTO;
    }
    public Author updateEntityFromDto(AuthorUpdateDTO authorUpdateDTO, Author author){
        if( authorUpdateDTO.getName() != null ){
            author.setName(authorUpdateDTO.getName());
        }
        if( authorUpdateDTO.getEmail() != null ){
            author.setEmail(authorUpdateDTO.getEmail());
        }
        return author;
    }
}