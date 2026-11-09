package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(nullable = false)
    private LocalDate borrowDate;
    @Column(nullable = false)
    private LocalDate dueDate;
    private LocalDate returnDate;
}
