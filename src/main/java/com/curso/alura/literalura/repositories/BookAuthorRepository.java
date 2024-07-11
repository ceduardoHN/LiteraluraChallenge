package com.curso.alura.literalura.repositories;

import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.models.BookAuthor;
import com.curso.alura.literalura.models.BookAuthorID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Soriano
 */
@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorID> {
    List<BookAuthor> findByidBook(Book book);
    List<BookAuthor> findByidAuthor(Author author);
}
