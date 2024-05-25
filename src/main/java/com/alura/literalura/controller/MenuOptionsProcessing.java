package com.alura.literalura.controller;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookData;
import com.alura.literalura.repository.IBookRepository;
import com.alura.literalura.service.ConsumeApi;
import com.alura.literalura.service.ConvertData;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuOptionsProcessing {
    private Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://gutendex.com/books/?search=";
    private ConsumeApi consumeApi = new ConsumeApi();
    private ConvertData conversor = new ConvertData();
    private List<BookData> bookDataList = new ArrayList<>();
    private IBookRepository repository;

    public void processMenuOption() {
        searchBook();
    }

    private void searchBook() {
        try {
            BookData bookData = getBookData();
            Book book = new Book(bookData);
            repository.save(book);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Este libro ya fue registrado previamente");
        } catch (NullPointerException e) {
            System.out.println("No se encontró ningún libro\n");
        }
    }

    private BookData getBookData() {
        System.out.println("Ingresa el nombre de un libro para buscar: ");
        String bookTitle = sc.nextLine();
        String json = consumeApi.getData(BASE_URL + bookTitle.replace(" ", "%20"));
        BookData bookData = conversor.getData(json, BookData.class);
        return bookData;
    }
}
