package com.curso.alura.literalura.services;

import com.curso.alura.literalura.dtos.BookR;
import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.models.BookAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class DataService {
    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookAuthorService bookAuthorService;

    @Transactional
    public void saveData(List<BookR> bookResults) {
        bookResults.forEach(bookIterator -> {
            Book book = new Book();
            book.setTitle(bookIterator.title());
            book.setLanguages(bookIterator.languages());
            book.setDownloadCount(bookIterator.downloadCount());
            Book savedBook = bookService.saveBook(book);

            bookIterator.authorRS().forEach(authorIterator -> {
                Author author = new Author();
                author.setName(authorIterator.name());
                author.setBirthYear(authorIterator.birthYear());
                author.setDeathYear(authorIterator.deathYear());

                Author savedAuthor = authorService.saveAuthor(author);

                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setIdBook(savedBook);
                bookAuthor.setIdAuthor(savedAuthor);

                bookAuthorService.saveBookAuthor(bookAuthor);
            });
        });
    }
}
