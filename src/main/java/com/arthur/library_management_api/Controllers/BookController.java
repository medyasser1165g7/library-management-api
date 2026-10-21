    package com.arthur.library_management_api.Controllers;

    import com.arthur.library_management_api.DTOs.BookDTOs.BookCreateDTO;
    import com.arthur.library_management_api.DTOs.BookDTOs.BookResponseDTO;
    import com.arthur.library_management_api.DTOs.BookDTOs.BookUpdateDTO;
    import com.arthur.library_management_api.Services.BookService;
    import jakarta.validation.Valid;
    import lombok.AllArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/v1/books")
    @AllArgsConstructor
    public class BookController {
        private final BookService bookService;

        //create book // return a 201 CREATED
        @PostMapping
        public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO){
            return new ResponseEntity<>(bookService.createBook(bookCreateDTO), HttpStatus.CREATED);
        }

        //get book by id AND return 201 OK
        @GetMapping("/{id}")
        public ResponseEntity<BookResponseDTO>  getBookById(@PathVariable Long id){
            return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
        }
        //get all books
        @GetMapping
        public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        }
        //update a book by it's id
        @PutMapping("/{id}")
        public ResponseEntity<BookResponseDTO> updateBookById(@Valid @RequestBody BookUpdateDTO bookUpdateDTO, @PathVariable Long id){
            return new ResponseEntity<>(bookService.updateBookById(bookUpdateDTO, id), HttpStatus.OK);
        }

        //delete book
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
            bookService.deleteBookById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
