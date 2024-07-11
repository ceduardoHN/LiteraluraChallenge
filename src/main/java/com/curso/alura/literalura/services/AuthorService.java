package com.curso.alura.literalura.services;

import com.curso.alura.literalura.models.Author;
import com.curso.alura.literalura.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    public Author getAuthorById(long idAuthor){
        return this.authorRepository.findById(idAuthor).orElse(null);
    }

    @Transactional
    public Author saveAuthor(Author author){
        return this.authorRepository.save(author);
    }
}
