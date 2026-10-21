package com.arthur.library_management_api.Controllers;

import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingCreateDTO;
import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingResponseDTO;
import com.arthur.library_management_api.Services.BorrowingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/borrowing")
@AllArgsConstructor
public class BorrowingController {
    private final BorrowingService borrowingService;

    //borrow a book
    @PostMapping
    public ResponseEntity<BorrowingResponseDTO> borrowBook(@Valid @RequestBody BorrowingCreateDTO borrowingCreateDTO){
        BorrowingResponseDTO responseDTO = borrowingService.borrowBook(borrowingCreateDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //get borrowing by id
    @GetMapping("/{id}")
    public ResponseEntity<BorrowingResponseDTO> getBorrowingById(@PathVariable Long id){
        BorrowingResponseDTO responseDTO = borrowingService.getBorrowingById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }
    //return a book
    @PutMapping("/{id}/return")
    public ResponseEntity<BorrowingResponseDTO> returnBook(@PathVariable Long id){
        System.out.println("returnBook controller reached, id = " + id);
        BorrowingResponseDTO responseDTO = borrowingService.returnBook(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
