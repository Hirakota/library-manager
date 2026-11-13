package com.example.library_manager.features.client.domain;

import com.example.library_manager.features.loan.domain.LoanEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<LoanEntity> loans = new ArrayList<>();
}
