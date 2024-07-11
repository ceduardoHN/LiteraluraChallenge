package com.curso.alura.literalura.services;

import com.curso.alura.literalura.models.Book;
import com.curso.alura.literalura.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book getBookById(long idBook){
        return this.bookRepository.findById(idBook).orElse(null);
    }

    public Book getBookByTitle(String title){
        return this.bookRepository.findByTitle(title);
    }

    @Transactional
    public Book saveBook(Book book){
        return this.bookRepository.save(book);
    }
}
