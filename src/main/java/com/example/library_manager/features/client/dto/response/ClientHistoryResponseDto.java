package com.example.library_manager.features.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClientHistoryResponseDto {
    private String bookTitle;
    private String bookIsbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
}
