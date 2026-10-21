package com.arthur.library_management_api.DTOs.BorrowingDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowingCreateDTO {
    @NotNull
    private Long memberId;
    @NotNull
    private Long bookId;

}
