package com.example.library_manager.features.author.service;

import com.example.library_manager.common.exception.NotFoundException;
import com.example.library_manager.features.author.adapter.AuthorMapper;
import com.example.library_manager.features.author.domain.AuthorEntity;
import com.example.library_manager.features.author.dto.request.AuthorRequestDto;
import com.example.library_manager.features.author.dto.response.AuthorResponseDto;
import com.example.library_manager.features.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorResponseDto createAuthor(AuthorRequestDto dto) {
        AuthorEntity author = AuthorEntity.builder()
                .name(dto.getName())
                .biography(dto.getBiography())
                .build();

        authorRepository.save(author);

        return AuthorMapper.mapToDto(author);
    }

    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorMapper::mapToDto).toList();
    }

    public AuthorResponseDto getAuthorById(Long id) {
        AuthorEntity author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Author not found"));

        return AuthorMapper.mapToDto(author);
    }
}
