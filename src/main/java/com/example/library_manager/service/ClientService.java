package com.example.library_manager.service;

import com.example.library_manager.adapters.ClientMapper;
import com.example.library_manager.domain.ClientEntity;
import com.example.library_manager.dto.request.ClientRequestDto;
import com.example.library_manager.dto.response.ClientHistoryResponseDto;
import com.example.library_manager.dto.response.ClientResponseDto;
import com.example.library_manager.exception.AlreadyExistException;
import com.example.library_manager.exception.NotFoundException;
import com.example.library_manager.repository.ClientRepository;
import com.example.library_manager.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final LoanRepository loanRepository;

    public ClientResponseDto createClient(ClientRequestDto dto) {
        if (clientRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new AlreadyExistException("Such email already busy: " + dto.getEmail());
        }
        ;

        ClientEntity client = ClientEntity.builder().fullName(dto.getFullName()).email(dto.getEmail()).build();

        clientRepository.save(client);

        return ClientMapper.mapToDto(client);
    }

    public List<ClientResponseDto> getAllClients() {
        return clientRepository.findAll().stream().map(ClientMapper::mapToDto).toList();
    }

    public ClientResponseDto getClientById(Long id) {
        return ClientMapper.mapToDto(clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with such id is not exist")));
    }

    @Transactional(readOnly = true)
    public List<ClientHistoryResponseDto> getClientHistory(Long id, boolean showBorrowedOnly) {
        clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with such id is not exist"));
        return loanRepository.findClientHistory(id, showBorrowedOnly);
    }
}
