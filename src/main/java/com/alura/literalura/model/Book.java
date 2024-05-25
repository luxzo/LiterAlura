package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(unique = true)
    private String title;

    private Long downloadCount;
    @ManyToMany
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    List<Author> authorOfBook;

    @ManyToMany
    @JoinTable(
            name = "language_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    List<Language> languageOfBook;

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.downloadCount = bookData.downloadCount();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<Author> getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(List<Author> authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public List<Language> getLanguageOfBook() {
        return languageOfBook;
    }

    public void setLanguageOfBook(List<Language> languageOfBook) {
        this.languageOfBook = languageOfBook;
    }

    @Override
    public String toString() {
        return "Book: {" +
                "title= " + title +
                ", downloadCount= " + downloadCount +
                ", authorOfBook= " + authorOfBook +
                ", languageOfBook= " + languageOfBook +
                '}';
    }
}
