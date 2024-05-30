package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private Integer yearOfBirth;

    private Integer yearOfDeath;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(AuthorData authorData) {
        this.name = authorData.name();
        try {
            this.yearOfBirth = authorData.yearOfBirth();
        } catch (NumberFormatException e) {
            this.yearOfBirth = null;
        }
        try {
            this.yearOfDeath = authorData.yearOfDeath();
        } catch (NumberFormatException e) {
            this.yearOfDeath = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        books.forEach(b -> b.setAuthor(this));
        this.books = books;
    }

    @Override
    public String toString() {
        return "Autor {" +
                "Nombre = '" + name + '\'' +
                ", Año de nacimiento =" + yearOfBirth +
                ", Año de fallecimiento =" + yearOfDeath +
                ", Libros = " + books +
                '}';
    }
}
