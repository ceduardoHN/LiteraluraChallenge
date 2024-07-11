package com.curso.alura.literalura.services;

import com.curso.alura.literalura.dtos.AuthorR;
import com.curso.alura.literalura.dtos.BookR;
import java.util.List;

/**
 * @author Soriano
 */
public class FormatObject {
    public String formatBookInfo(BookR bookR) {
        return String.format("""
                Título: %s
                Autor(es): %s
                Idioma(s): %s
                Número de Descargas: %d
                """,
                bookR.title(),
                this.formatAuthors(bookR.authorRS()),
                bookR.languages(),
                bookR.downloadCount()
        );
    }

    private String formatAuthors(List<AuthorR> authorRS) {
        StringBuilder sb = new StringBuilder();

        authorRS.forEach(authorR -> {
            sb.append(authorR.name());
            if (authorRS.indexOf(authorR) < authorRS.size() - 1) {
                sb.append("; ");
            }
        });

        return sb.toString();
    }
}
