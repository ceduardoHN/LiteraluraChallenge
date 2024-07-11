package com.curso.alura.literalura.models;

/**
 * @author Soriano
 */
public class BookAuthorID {
    public BookAuthorID() {
    }

    /**
     * @param idBook
     * @param idAuthor
     */
    public BookAuthorID(Book idBook, Author idAuthor) {
        this.idBook = idBook;
        this.idAuthor = idAuthor;
    }

    private Book idBook;
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
