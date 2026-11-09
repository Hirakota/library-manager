package com.example.library_manager.service;

import com.example.library_manager.adapters.LoanMapper;
import com.example.library_manager.domain.BookEntity;
import com.example.library_manager.domain.ClientEntity;
import com.example.library_manager.domain.LoanEntity;
import com.example.library_manager.dto.request.LoanRequestDto;
import com.example.library_manager.dto.response.LoanResponseDto;
import com.example.library_manager.enums.BookStatuses;
import com.example.library_manager.exception.BadRequestException;
import com.example.library_manager.exception.NotFoundException;
import com.example.library_manager.repository.BookRepository;
import com.example.library_manager.repository.ClientRepository;
import com.example.library_manager.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;

    @Transactional
    public LoanResponseDto borrowBook(LoanRequestDto dto) {
        BookEntity book = bookRepository.findById(dto.getBookId()).orElseThrow(() -> new NotFoundException("Book with such id is not exist"));
        if (book.getStatus() != BookStatuses.AVAILABLE) {
            throw new BadRequestException("Book is not available");
        }

        ClientEntity client = clientRepository.findById(dto.getClientId()).orElseThrow(() -> new NotFoundException("Client with such id is not exist"));

        LoanEntity loan = LoanEntity.builder()
                .book(book)
                .client(client)
                .borrowDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .build();

        // update book status
        book.setStatus(BookStatuses.BORROWED);
        bookRepository.save(book);

        loanRepository.save(loan);
        return LoanMapper.mapToDto(loan);
    }

    @Transactional
    public void returnBook(Long id) {
        LoanEntity loan = loanRepository.findById(id).orElseThrow(() -> new NotFoundException("No such loan"));

        if (loan.getReturnDate() != null) {
            throw new BadRequestException("Book is already returned");
        }

        BookEntity book = loan.getBook();

        // Update book status
        book.setStatus(BookStatuses.AVAILABLE);
        bookRepository.save(book);

        //Update loan status
        loan.setReturnDate(LocalDate.now());
        loanRepository.save(loan);
    }
}
