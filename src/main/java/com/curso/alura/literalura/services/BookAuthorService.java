package com.curso.alura.literalura.services;

import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.models.BookAuthor;
import com.curso.alura.literalura.repositories.BookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class BookAuthorService {
    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public List<BookAuthor> getAuthorsByIdBook(long idBook){
        Book book = this.bookService.getBookById(idBook);

        return this.bookAuthorRepository.findByidBook(book);
    }

    public List<BookAuthor> getBooksByIdAuthor(long idAuthor){
        Author author = this.authorService.getAuthorById(idAuthor);

        return this.bookAuthorRepository.findByidAuthor(author);
    }

    @Transactional
    public BookAuthor saveBookAuthor(BookAuthor bookAuthor){
        return this.bookAuthorRepository.save(bookAuthor);
    }
}
