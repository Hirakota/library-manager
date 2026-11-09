package com.example.library_manager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String fullName;
    private String email;
}
