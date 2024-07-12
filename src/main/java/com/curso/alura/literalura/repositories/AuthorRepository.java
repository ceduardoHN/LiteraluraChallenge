package com.curso.alura.literalura.repositories;

import com.curso.alura.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Soriano
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int birthYear, int deathYear);
}
