package com.example.library_manager.adapters;

import com.example.library_manager.domain.AuthorEntity;
import com.example.library_manager.dto.response.AuthorResponseDto;

public class AuthorMapper {
    public static AuthorResponseDto mapToDto(AuthorEntity author) {
        return new AuthorResponseDto(author.getId(), author.getName(), author.getBiography());
    }
}
