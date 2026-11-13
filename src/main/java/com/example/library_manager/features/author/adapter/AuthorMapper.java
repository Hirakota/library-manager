package com.example.library_manager.features.author.adapter;

import com.example.library_manager.features.author.domain.AuthorEntity;
import com.example.library_manager.features.author.dto.response.AuthorResponseDto;

public class AuthorMapper {
    public static AuthorResponseDto mapToDto(AuthorEntity author) {
        return new AuthorResponseDto(author.getId(), author.getName(), author.getBiography());
    }
}
