package com.example.library_manager.features.author.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorRequestDto {
    @NotBlank(message = "Name should not be empty")
    private String name;

    @Size(min = 0, max = 1000, message = "Bio must be between 0 and 1000 characters")
    private String biography;
}
