package com.curso.alura.literalura.repositories;

import com.curso.alura.literalura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Soriano
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);

    @Query(value = "SELECT * FROM tblbook b WHERE :language = ANY(b.languages)", nativeQuery = true)
    List<Book> findByLanguage(@Param("language") String language);
}
