package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Soriano
 */
@Entity
@Table(name = "tblbook")
public class Book implements Serializable {
    public Book() {
    }

    /**
     * @param title
     * @param languages
     * @param downloadCount
     */
    public Book(String title, List<String> languages, int downloadCount) {
        this.title = title;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    /**
     * @param idBook
     * @param title
     * @param languages
     * @param downloadCount
     */
    public Book(long idBook, String title, List<String> languages, int downloadCount) {
        this.idBook = idBook;
        this.title = title;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;

    @Column(unique = true)
    private String title;

    private List<String> languages;
    private int downloadCount;

    @OneToMany(mappedBy = "idBook", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("idBook")
    private List<BookAuthor> bookAuthors;

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
}
