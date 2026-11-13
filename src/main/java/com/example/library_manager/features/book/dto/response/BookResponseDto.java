package com.example.library_manager.features.book.dto.response;

import com.example.library_manager.features.author.dto.response.AuthorResponseDto;
import com.example.library_manager.features.book.enums.BookStatuses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private BookStatuses statuses;

    private List<AuthorResponseDto> authors;
}
