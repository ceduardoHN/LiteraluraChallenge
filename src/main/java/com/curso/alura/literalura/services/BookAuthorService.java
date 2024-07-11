package com.curso.alura.literalura.services;

import com.curso.alura.literalura.models.BookAuthor;
import com.curso.alura.literalura.repositories.BookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Soriano
 */
@Service
public class BookAuthorService {
    @Autowired
    BookAuthorRepository bookAuthorRepository;

    @Transactional
    public BookAuthor saveBookAuthor(BookAuthor bookAuthor){
        return this.bookAuthorRepository.save(bookAuthor);
    }
}
