package com.curso.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Soriano
 */
@Entity
@Table(name = "tblauthor")
public class Author implements Serializable {
    public Author() {
    }

    /**
     * @param name
     * @param birthYear
     * @param deathYear
     */
    public Author(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    /**
     * @param idAuthor
     * @param name
     * @param birthYear
     * @param deathYear
     */
    public Author(long idAuthor, String name, int birthYear, int deathYear) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAuthor;

    private String name;
    private int birthYear;
    private int deathYear;

    @OneToMany(mappedBy = "idAuthor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("idAuthor")
    private List<BookAuthor> bookAuthors;


    public long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }
}
