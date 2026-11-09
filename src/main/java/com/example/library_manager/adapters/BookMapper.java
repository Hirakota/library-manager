package com.example.library_manager.adapters;

import com.example.library_manager.domain.BookEntity;
import com.example.library_manager.dto.response.AuthorResponseDto;
import com.example.library_manager.dto.response.BookResponseDto;

import java.util.List;

public class BookMapper {
    public static BookResponseDto mapToDto(BookEntity book) {
        List<AuthorResponseDto> authors = book.getAuthors().stream().map(AuthorMapper::mapToDto).toList();
        return new BookResponseDto(book.getId(), book.getTitle(), book.getIsbn(), book.getStatus(), authors);
    }
}
