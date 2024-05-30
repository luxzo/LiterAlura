package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(unique = true)
    private String title;

    @ManyToOne
    private Author author;

    private Long downloadCount;

    private List<String> language;

   /* public Book(BookData bookData) {
        this.title = bookData.title();
        this.downloadCount = bookData.downloadCount();
        this.language = bookData.language();
    }*/

    public Book(String title, Long downloadCount, List<String> language) {
        this.title = title;
        this.downloadCount = downloadCount;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "Título = '" + title + '\'' +
                ", Número de descargas =" + downloadCount +
                ", Idioma = '" + language + '\'' +
                '}';
    }
}
