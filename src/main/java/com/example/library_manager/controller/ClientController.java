package com.example.library_manager.controller;

import com.example.library_manager.dto.request.ClientRequestDto;
import com.example.library_manager.dto.response.ClientHistoryResponseDto;
import com.example.library_manager.dto.response.ClientResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clients")
public class ClientController {

    private final com.example.library_manager.service.ClientService clientService;

    @GetMapping
    ResponseEntity<List<ClientResponseDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody ClientRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(dto));
    }

    @GetMapping("/{id}/history")
    ResponseEntity<List<ClientHistoryResponseDto>> clientHistory(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "false") boolean showBorrowedOnly
    ) {
        return ResponseEntity.ok(clientService.getClientHistory(id, showBorrowedOnly));
    }
}
