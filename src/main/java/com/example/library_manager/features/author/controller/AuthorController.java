package com.example.library_manager.features.author.controller;

import com.example.library_manager.features.author.dto.request.AuthorRequestDto;
import com.example.library_manager.features.author.dto.response.AuthorResponseDto;
import com.example.library_manager.features.author.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
@Tag(name = "Authors", description = "Author controller")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @Operation(summary = "Create author")
    ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody @Valid AuthorRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createAuthor(dto));
    }

    @GetMapping
    @Operation(summary = "Get all authors")
    ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Author by Id")
    ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
