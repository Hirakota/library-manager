package com.example.library_manager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String biography;
}
