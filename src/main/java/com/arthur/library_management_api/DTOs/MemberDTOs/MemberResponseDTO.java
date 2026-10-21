package com.arthur.library_management_api.DTOs.MemberDTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter@Setter
public class MemberResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime joinedAt;
}
