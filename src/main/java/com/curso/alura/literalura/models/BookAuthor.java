package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author Soriano
 */
@Entity
@IdClass(BookAuthorID.class)
@Table(name="tblbookauthor")
public class BookAuthor implements Serializable {
    public BookAuthor() {
    }

    /**
     * @param idBook
     * @param idAuthor
     */
    public BookAuthor(Book idBook, Author idAuthor) {
        this.idBook = idBook;
        this.idAuthor = idAuthor;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "idBook", referencedColumnName = "idBook" )
    @JsonIncludeProperties({"idBook", "title", "languages", "downloadCount"})
    private Book idBook;

    @Id
    @ManyToOne
    @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor" )
    @JsonIncludeProperties({"idAuthor", "name", "birthYear", "deathYear"})
    private Author idAuthor;

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }
}
