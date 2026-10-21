package com.arthur.library_management_api.DTOs.BorrowingDTOs;

import com.arthur.library_management_api.DTOs.BookDTOs.BookSummaryDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class BorrowingResponseDTO {
    private Long id;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnDate;
    private LocalDateTime dueDate;
    private MemberResponseDTO memberResponseDTO;
    private BookSummaryDTO bookSummaryDTO;
}
