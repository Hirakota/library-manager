package com.example.library_manager.features.loan.adapter;

import com.example.library_manager.features.loan.domain.LoanEntity;
import com.example.library_manager.features.loan.dto.response.LoanResponseDto;

public class LoanMapper {
    public static LoanResponseDto mapToDto(LoanEntity entity) {
        return new LoanResponseDto(
                entity.getId(),
                entity.getBook().getTitle(),
                entity.getClient().getFullName(),
                entity.getBorrowDate(),
                entity.getDueDate()
        );
    }
}
