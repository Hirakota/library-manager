package com.example.library_manager.features.loan.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanRequestDto {
    @NotNull
    private Long bookId;
    @NotNull
    private Long clientId;
}
