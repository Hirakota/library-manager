package com.example.library_manager.repository;

import com.example.library_manager.domain.ClientEntity;
import com.example.library_manager.domain.LoanEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
    @EntityGraph(attributePaths = {"client", "book"})
    List<LoanEntity> findAll();

    @EntityGraph(attributePaths = {"client", "book"})
    Optional<LoanEntity> findById(Long id);

    List<LoanEntity> findByClientAndReturnDateIsNull(ClientEntity client);
}
