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
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookAuthorService bookAuthorService;

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
                Author savedAuthor = new Author();
                author.setName(authorIterator.name());
                author.setBirthYear(authorIterator.birthYear());
                author.setDeathYear(authorIterator.deathYear());

                if(this.authorService.getAuthorByName(authorIterator.name())!=null){
                    savedAuthor = this.authorService.getAuthorByName(authorIterator.name());
                }
                else{
                    savedAuthor = authorService.saveAuthor(author);
                }

                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setIdBook(savedBook);
                bookAuthor.setIdAuthor(savedAuthor);

                bookAuthorService.saveBookAuthor(bookAuthor);
            });
        });
    }

    public boolean verifyBook(String title){
        Book book = this.bookService.getBookByTitle(title);

        if(book!=null){
            return true;
        }

        return false;
    }
}
