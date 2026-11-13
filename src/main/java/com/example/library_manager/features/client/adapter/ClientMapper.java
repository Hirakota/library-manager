package com.example.library_manager.features.client.adapter;

import com.example.library_manager.features.client.domain.ClientEntity;
import com.example.library_manager.features.client.dto.response.ClientResponseDto;

public class ClientMapper {
    public static ClientResponseDto mapToDto(ClientEntity client) {
        return new ClientResponseDto(client.getId(), client.getFullName(), client.getEmail());
    }
}
