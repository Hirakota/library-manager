package com.example.library_manager.features.loan.controller;

import com.example.library_manager.features.loan.dto.request.LoanRequestDto;
import com.example.library_manager.features.loan.dto.response.LoanResponseDto;
import com.example.library_manager.features.loan.service.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
@Tag(name = "Loans")
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/borrow")
    ResponseEntity<LoanResponseDto> borrowBook(@Valid @RequestBody LoanRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.borrowBook(dto));
    }

    @PostMapping("/{id}/return")
    ResponseEntity<String> returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
        return ResponseEntity.ok("Success");
    }
}
