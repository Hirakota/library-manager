package com.example.library_manager.adapters;

import com.example.library_manager.domain.ClientEntity;
import com.example.library_manager.dto.response.ClientResponseDto;

public class ClientMapper {
    public static ClientResponseDto mapToDto(ClientEntity client) {
        return new ClientResponseDto(client.getId(), client.getFullName(), client.getEmail());
    }
}
