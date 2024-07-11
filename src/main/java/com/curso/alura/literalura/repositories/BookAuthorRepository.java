package com.curso.alura.literalura.repositories;

import com.curso.alura.literalura.models.BookAuthor;
import com.curso.alura.literalura.models.BookAuthorID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Soriano
 */
@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorID> {
}
