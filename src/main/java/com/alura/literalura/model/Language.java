package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String langAbrv;

    public Language(LanguageData languageData) {
        this.langAbrv = languageData.langAbrv();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLangAbrv() {
        return langAbrv;
    }

    public void setLangAbrv(String langAbrv) {
        this.langAbrv = langAbrv;
    }

    @Override
    public String toString() {
        return "Language {" +
                "languages = " + langAbrv +
                '}';
    }
}
