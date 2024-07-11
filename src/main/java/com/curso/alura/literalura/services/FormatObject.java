package com.curso.alura.literalura.services;

import com.curso.alura.literalura.dtos.AuthorR;
import com.curso.alura.literalura.dtos.BookR;
import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.models.BookAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class FormatObject {
    @Autowired
    AuthorService authorService;

    @Autowired
    BookAuthorService bookAuthorService;

    public String formatBookRInfo(BookR bookR) {
        return String.format("""
                Título: %s
                Autor(es): %s
                Idioma(s): %s
                Número de Descargas: %d
                """,
                bookR.title(),
                this.formatAuthorRs(bookR.authorRS()),
                this.formatLanguages(bookR.languages()),
                bookR.downloadCount()
        );
    }

    public String formatBookInfo(Book book) {
        return String.format("""
                Título: %s
                Autor(es): %s
                Idioma(s): %s
                Número de Descargas: %d
                """,
                book.getTitle(),
                this.formatAuthors(this.bookAuthorService.getAuthorsByIdBook(book.getIdBook())),
                this.formatLanguages(book.getLanguages()),
                book.getDownloadCount()
        );
    }

    private String formatAuthors(List<BookAuthor> bookAuthors) {
        StringBuilder sb = new StringBuilder();

        bookAuthors.forEach(bookAuthorIterator -> {
            Author author = this.authorService.getAuthorById(bookAuthorIterator.getIdAuthor().getIdAuthor());
            sb.append(author.getName());

            if (bookAuthors.indexOf(bookAuthorIterator) < bookAuthors.size() - 1) {
                sb.append("; ");
            }
        });

        return sb.toString();
    }

    private String formatAuthorRs(List<AuthorR> authorRS) {
        StringBuilder sb = new StringBuilder();

        authorRS.forEach(authorRIterator -> {
            sb.append(authorRIterator.name());
            if (authorRS.indexOf(authorRIterator) < authorRS.size() - 1) {
                sb.append("; ");
            }
        });

        return sb.toString();
    }

    private String formatLanguages(List<String> languages){
        StringBuilder sb = new StringBuilder();

        languages.forEach(lanIterator -> {
            lanIterator.replace("[","").replace("]","");
            sb.append(lanIterator);

            if(languages.indexOf(lanIterator) < languages.size() - 1){
                sb.append(", ");
            }
        });

        return sb.toString();
    }
}
