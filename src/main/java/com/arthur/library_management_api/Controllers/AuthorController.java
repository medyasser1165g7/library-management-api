package com.arthur.library_management_api.Controllers;

import com.arthur.library_management_api.DTOs.AuthorCreateDTO;
import com.arthur.library_management_api.DTOs.AuthorDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorResponseDTO;
import com.arthur.library_management_api.DTOs.AuthorUpdateDTO;
import com.arthur.library_management_api.Services.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(@Valid @RequestBody AuthorCreateDTO authorCreateDTO){
        AuthorResponseDTO authorResponseDTO = authorService.createAuthor(authorCreateDTO);
        URI location = URI.create("/api/v1/authors/" + authorResponseDTO.getId());
        return ResponseEntity.created(location).body(authorResponseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDetailsResponseDTO> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthor(id));
    }
    @GetMapping
    public ResponseEntity<List<AuthorDetailsResponseDTO>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @PutMapping("/{id}")
        public ResponseEntity<AuthorResponseDTO> updateAuthor(@Valid @RequestBody AuthorUpdateDTO authorUpdateDTO, @PathVariable Long id){
        return ResponseEntity.ok(authorService.updateAuthorByAuthorId(authorUpdateDTO, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}
