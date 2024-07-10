package com.curso.alura.literalura.services;

import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
import java.util.List;

/**
 * @author Soriano
 */
public class FormatObject {
    public String formatBookInfo(Book book) {
        return String.format("""
                Título: %s
                Autor(es): %s
                Idioma(s): %s
                Número de Descargas: %d
                """,
                book.title(),
                this.formatAuthors(book.authors()),
                book.languages(),
                book.downloadCount()
        );
    }

    private String formatAuthors(List<Author> authors) {
        StringBuilder sb = new StringBuilder();

        authors.forEach(author -> {
            sb.append(author.name());
            if (authors.indexOf(author) < authors.size() - 1) {
                sb.append(", ");
            }
        });

        return sb.toString();
    }
}
