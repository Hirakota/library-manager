package com.example.library_manager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class LoanResponseDto {
    private Long id;
    private String bookTitle;
    private String clientName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
}
