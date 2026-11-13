package com.example.library_manager.features.book.service;

import com.example.library_manager.common.exception.NotFoundException;
import com.example.library_manager.features.author.domain.AuthorEntity;
import com.example.library_manager.features.author.repository.AuthorRepository;
import com.example.library_manager.features.book.adapter.BookMapper;
import com.example.library_manager.features.book.domain.BookEntity;
import com.example.library_manager.features.book.dto.request.BookRequestDto;
import com.example.library_manager.features.book.dto.response.BookResponseDto;
import com.example.library_manager.features.book.enums.BookStatuses;
import com.example.library_manager.features.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public BookResponseDto createBook(BookRequestDto dto) {
        List<AuthorEntity> authors = dto.getAuthorIds().stream()
                .map(id -> authorRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Author not found: " + id)))
                .toList();

        BookEntity book = BookEntity.builder()
                .title(dto.getTitle())
                .isbn(dto.getIsbn())
                .status(BookStatuses.AVAILABLE)
                .authors(authors)
                .build();

        bookRepository.save(book);

        return BookMapper.mapToDto(book);
    }

    @Transactional
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream().map(BookMapper::mapToDto).toList();
    }

    @Transactional
    public BookResponseDto getBookById(Long id) {
        return BookMapper.mapToDto(bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found")));
    }

    @Transactional
    public void deleteBookById(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot delete the book, book dose not exist"));

        bookRepository.deleteById(id);
    }

}
