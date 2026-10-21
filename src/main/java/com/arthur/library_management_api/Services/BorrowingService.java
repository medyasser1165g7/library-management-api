package com.arthur.library_management_api.Services;

import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingCreateDTO;
import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingResponseDTO;
import com.arthur.library_management_api.Entities.Book;
import com.arthur.library_management_api.Entities.Borrowing;
import com.arthur.library_management_api.Entities.Member;
import com.arthur.library_management_api.Exceptions.BookNotFoundException;
import com.arthur.library_management_api.Exceptions.BookUnavailableException;
import com.arthur.library_management_api.Mappers.BorrowingMapper;
import com.arthur.library_management_api.Repositories.BookRepository;
import com.arthur.library_management_api.Repositories.BorrowingRepository;
import com.arthur.library_management_api.Repositories.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final BorrowingMapper borrowingMapper;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    //borrow a book
    public BorrowingResponseDTO borrowBook(BorrowingCreateDTO borrowingCreateDTO){
        Book book = bookRepository.findById(borrowingCreateDTO.getBookId()).orElseThrow( () -> new BookNotFoundException("Book with id: " + borrowingCreateDTO.getBookId() + " not found."));
        Member member = memberRepository.findById(borrowingCreateDTO.getMemberId()).orElseThrow(); // implement member not found exception later
        if( !book.isAvailable() ){
            throw new BookUnavailableException("book with id: " + book.getId() + " is unavailable. "); // to implement the book not available exception
        }

        Borrowing borrowing = borrowingMapper.toEntity(book, member);
        book.setAvailable(false);
        bookRepository.save(book);
        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        return borrowingMapper.toBorrowingResponseDto(saveBorrowing);
    }
    //get borrowing by id
    public BorrowingResponseDTO getBorrowingById(Long id){
        BorrowingResponseDTO borrowingResponseDTO = borrowingMapper.toBorrowingResponseDto(borrowingRepository.findById(id).orElseThrow()); // implement borrowing not found exception later
        return borrowingResponseDTO;
    }

    //return a book
    public BorrowingResponseDTO returnBook(Long borrowingId){
        Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(); // implement borrowing not found exception later

        if (borrowing.getReturnedAt() != null) {
            throw new RuntimeException(); // implement exception later
        }
        borrowing.setReturnedAt(LocalDateTime.now());
        Book book = borrowing.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        return borrowingMapper.toBorrowingResponseDto(saveBorrowing);
    }
}