package com.arthur.library_management_api.Mappers;

import com.arthur.library_management_api.DTOs.AuthorDTOs.AuthorResponseDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookCreateDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookResponseDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookSummaryDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookUpdateDTO;
import com.arthur.library_management_api.Entities.Author;
import com.arthur.library_management_api.Entities.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {

    public Book toEntity(BookCreateDTO dto, Author author){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPublishedYear(dto.getPublished_year());
        book.setAuthor(author);
        return book;
    }
    public BookResponseDTO toBookResponseDTO(Book book){
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setId(book.getId());
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setIsbn(book.getIsbn());
        bookResponseDTO.setPublished_year(book.getPublishedYear());
        bookResponseDTO.setAvailable(book.isAvailable());
        AuthorResponseDTO authorDTO = new AuthorResponseDTO();
        authorDTO.setId(book.getAuthor().getId());
        authorDTO.setName(book.getAuthor().getName());
        authorDTO.setEmail(book.getAuthor().getEmail());

        bookResponseDTO.setAuthorResponseDTO(authorDTO);
        return bookResponseDTO;
    }
    public BookSummaryDTO toBookSummaryDTO(Book book){
        BookSummaryDTO bookSummaryDTO = new BookSummaryDTO();
        bookSummaryDTO.setId(book.getId());
        bookSummaryDTO.setTitle(book.getTitle());
        bookSummaryDTO.setIsbn(book.getIsbn());
        bookSummaryDTO.setPublished_year(book.getPublishedYear());

        return bookSummaryDTO;
    }
    public Book updateEntityFromDto(
            BookUpdateDTO dto, Book book, Author author) {
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPublishedYear(dto.getPublished_year());
        book.setAuthor(author);

        return book;
    }
}
