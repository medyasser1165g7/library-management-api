package com.arthur.library_management_api.Mappers;

import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingCreateDTO;
import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingResponseDTO;
import com.arthur.library_management_api.Entities.Book;
import com.arthur.library_management_api.Entities.Borrowing;
import com.arthur.library_management_api.Entities.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class BorrowingMapper {

    private final BookMapper bookMapper;
    private final MemberMapper memberMapper;
    //to entity
    public Borrowing toEntity(Book book, Member member){
        LocalDateTime borrowedAt = LocalDateTime.now();
        Borrowing borrowing = new Borrowing();

        borrowing.setBook(book);
        borrowing.setMember(member);
        borrowing.setBorrowedAt(borrowedAt);
        borrowing.setDueDate(borrowedAt.plusDays(14));
        return borrowing;
    }
    // book and member to be set at the service layer
    public BorrowingResponseDTO toBorrowingResponseDto(Borrowing borrowing){
        BorrowingResponseDTO borrowingResponseDTO = new BorrowingResponseDTO();

        borrowingResponseDTO.setId(borrowing.getId());
        borrowingResponseDTO.setBorrowedAt(borrowing.getBorrowedAt());
        borrowingResponseDTO.setDueDate(borrowing.getDueDate());
        borrowingResponseDTO.setReturnDate(borrowing.getReturnedAt());
        borrowingResponseDTO.setMemberResponseDTO(memberMapper.toMemberResponseDTO(borrowing.getMember()));
        borrowingResponseDTO.setBookSummaryDTO(bookMapper.toBookSummaryDTO(borrowing.getBook()));
        return borrowingResponseDTO;
    }
}
