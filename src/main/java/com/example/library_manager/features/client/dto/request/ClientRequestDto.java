package com.example.library_manager.features.client.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientRequestDto {
    @NotBlank(message = " Name cannot be empty")
    private String fullName;

    @NotBlank
    @Email(message = "Invalid email format")
    private String email;
}
