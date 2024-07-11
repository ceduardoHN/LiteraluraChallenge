package com.curso.alura.literalura.services;

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
    BookAuthorRepository bookAuthorRepository;

    @Autowired
    BookService bookService;

    public List<BookAuthor> getAuthorsByIdBook(long idBook){
        Book book = this.bookService.getBookById(idBook);

        return this.bookAuthorRepository.findByidBook(book);
    }

    @Transactional
    public BookAuthor saveBookAuthor(BookAuthor bookAuthor){
        return this.bookAuthorRepository.save(bookAuthor);
    }
}
