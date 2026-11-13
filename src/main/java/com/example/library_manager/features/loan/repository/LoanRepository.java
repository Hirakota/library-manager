package com.example.library_manager.features.loan.repository;

import com.example.library_manager.features.client.domain.ClientEntity;
import com.example.library_manager.features.client.dto.response.ClientHistoryResponseDto;
import com.example.library_manager.features.loan.domain.LoanEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT new com.example.library_manager.dto.response.ClientHistoryResponseDto(b.title, b.isbn, l.borrowDate, l.dueDate, l.returnDate) " +
            "FROM LoanEntity l " +
            "JOIN l.book b " +
            "WHERE l.client.id = :id " +
            "AND (:showBorrowedOnly = false OR l.returnDate IS NULL)")
    List<ClientHistoryResponseDto> findClientHistory(@Param("id") Long id, @Param("showBorrowedOnly") boolean showBorrowedOnly);
}
