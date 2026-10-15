package com.arthur.library_management_api.Services;

import com.arthur.library_management_api.DTOs.AuthorCreateDTO;
import com.arthur.library_management_api.DTOs.AuthorDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorUpdateDTO;
import com.arthur.library_management_api.Entities.Author;
import com.arthur.library_management_api.Exceptions.AuthorNotFoundException;
import com.arthur.library_management_api.Mappers.AuthorMapper;
import com.arthur.library_management_api.Repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    //create author
    public AuthorResponseDTO createAuthor(AuthorCreateDTO authorCreateDTO){
        Author saveAuthor = authorRepository.save(authorMapper.toEntity(authorCreateDTO));
        return authorMapper.toAuthorResponseDTO(saveAuthor);
    }
    //get detailed author
    public AuthorDetailsResponseDTO getAuthor(Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow( () -> new AuthorNotFoundException("Author with id: " + authorId + " not found.")); // exception handling!!!
        return authorMapper.toAuthorDetailsResponseDTO(author);
    }
    //get all authors
    public List<AuthorDetailsResponseDTO> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        List<AuthorDetailsResponseDTO> detailedAuthorsResponse = new ArrayList<>();
        for(Author author: authors){
            detailedAuthorsResponse.add(authorMapper.toAuthorDetailsResponseDTO(author));
        }
        return detailedAuthorsResponse;
    }
    //update author
    public AuthorResponseDTO updateAuthorByAuthorId(AuthorUpdateDTO authorUpdateDTO, Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow( () -> new AuthorNotFoundException("Author with id: " + authorId + " not found."));
        Author saveAuthor = authorRepository.save(authorMapper.updateEntityFromDto(authorUpdateDTO, author));
        return authorMapper.toAuthorResponseDTO(saveAuthor);
    }
    //delete author by id
    public void deleteAuthorById(Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow( () -> new AuthorNotFoundException("Author with id: " + authorId + " not found."));
        authorRepository.delete(author);
    }
}
