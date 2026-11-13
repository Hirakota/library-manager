package com.example.library_manager.features.book.controller;

import com.example.library_manager.features.book.dto.request.BookRequestDto;
import com.example.library_manager.features.book.dto.response.BookResponseDto;
import com.example.library_manager.features.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Tag(name = "Books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @Operation(summary = "Create book")
    ResponseEntity<BookResponseDto> createBook(@RequestBody @Valid BookRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(dto));
    }

    @GetMapping
    @Operation(summary = "Get all books")
    ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id")
    ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by id")
    ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
