package com.example.library_manager.features.book.adapter;

import com.example.library_manager.features.author.adapter.AuthorMapper;
import com.example.library_manager.features.author.dto.response.AuthorResponseDto;
import com.example.library_manager.features.book.domain.BookEntity;
import com.example.library_manager.features.book.dto.response.BookResponseDto;

import java.util.List;

public class BookMapper {
    public static BookResponseDto mapToDto(BookEntity book) {
        List<AuthorResponseDto> authors = book.getAuthors().stream().map(AuthorMapper::mapToDto).toList();
        return new BookResponseDto(book.getId(), book.getTitle(), book.getIsbn(), book.getStatus(), authors);
    }
}
