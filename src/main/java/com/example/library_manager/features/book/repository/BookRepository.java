package com.example.library_manager.features.book.repository;

import com.example.library_manager.features.book.domain.BookEntity;
import com.example.library_manager.features.book.enums.BookStatuses;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Override
    @EntityGraph(attributePaths = "authors")
    List<BookEntity> findAll();

    List<BookEntity> findByStatus(BookStatuses status);

    List<BookEntity> findByTitleContainingIgnoreCase(String title);

    @Override
    @EntityGraph(attributePaths = "authors")
    Optional<BookEntity> findById(Long id);
}
