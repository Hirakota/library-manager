package com.example.library_manager.adapters;

import com.example.library_manager.domain.LoanEntity;
import com.example.library_manager.dto.response.LoanResponseDto;

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
