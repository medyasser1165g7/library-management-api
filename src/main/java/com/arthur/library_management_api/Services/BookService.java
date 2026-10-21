package com.arthur.library_management_api.Services;

import com.arthur.library_management_api.DTOs.BookDTOs.BookCreateDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookResponseDTO;
import com.arthur.library_management_api.DTOs.BookDTOs.BookUpdateDTO;
import com.arthur.library_management_api.Entities.Author;
import com.arthur.library_management_api.Entities.Book;
import com.arthur.library_management_api.Exceptions.AuthorNotFoundException;
import com.arthur.library_management_api.Exceptions.BookNotFoundException;
import com.arthur.library_management_api.Mappers.BookMapper;
import com.arthur.library_management_api.Repositories.AuthorRepository;
import com.arthur.library_management_api.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final BookMapper bookMapper;

    public BookResponseDTO createBook(BookCreateDTO bookCreateDTO){
        Author author = authorRepository.findById(bookCreateDTO.getAuthorId()).orElseThrow( () -> new AuthorNotFoundException("Author with id: " + bookCreateDTO.getAuthorId() + " not found."));
        Book book = bookRepository.save(bookMapper.toEntity(bookCreateDTO, author));
        return bookMapper.toBookResponseDTO(book);
    }
    //find book by id
    public BookResponseDTO getBookById(Long bookId){
        return bookMapper.toBookResponseDTO(bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book with id: " + bookId + " not found.")
        ));
    }
    //find books by author
    public List<BookResponseDTO> getBooksByAuthorId(Long authorId){
       List<BookResponseDTO> responseDTOList = new ArrayList<>();
       for( Book book: bookRepository.findAllByAuthor_Id(authorId)){
           responseDTOList.add(bookMapper.toBookResponseDTO(book));
       }
       return responseDTOList;
    }
    //get all books
    public List<BookResponseDTO> getAllBooks(){
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        for( Book book: bookRepository.findAll()){
            bookResponseDTOList.add(bookMapper.toBookResponseDTO(book));
        }
        return bookResponseDTOList;
    }
    //update book by id
    public BookResponseDTO updateBookById(BookUpdateDTO bookUpdateDTO, Long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow( () -> new BookNotFoundException("Book with id: " + bookId + " not found.") );
        Author author = authorRepository.findById(bookUpdateDTO.getAuthorId()).orElseThrow( () -> new AuthorNotFoundException("Author with id: " + bookUpdateDTO.getAuthorId() + " not found."));
        Book saveBook = bookRepository.save(bookMapper.updateEntityFromDto(bookUpdateDTO, book, author));

        return bookMapper.toBookResponseDTO(saveBook);
    }
    //delete book by id
    public void deleteBookById(Long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow( () -> new BookNotFoundException("Book with id: " + bookId + " not found.") );
        bookRepository.delete(book);
    }

}
