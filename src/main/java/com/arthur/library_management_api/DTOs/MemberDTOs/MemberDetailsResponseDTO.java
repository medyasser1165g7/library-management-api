package com.arthur.library_management_api.DTOs.MemberDTOs;

import com.arthur.library_management_api.DTOs.BorrowingDTOs.BorrowingResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter@Setter
public class MemberDetailsResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime joinedAt;
    private List<BorrowingResponseDTO> borrowings;
}
