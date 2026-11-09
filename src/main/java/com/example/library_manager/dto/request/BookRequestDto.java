package com.example.library_manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookRequestDto {
    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String isbn;

    private List<Long> authorIds;
}
