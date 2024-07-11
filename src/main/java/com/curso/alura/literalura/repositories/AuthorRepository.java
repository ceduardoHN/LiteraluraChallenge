package com.curso.alura.literalura.repositories;

import com.curso.alura.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Soriano
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
