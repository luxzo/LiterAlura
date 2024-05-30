package com.alura.literalura.controller;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookData;
import com.alura.literalura.model.ResultData;
import com.alura.literalura.repository.IBookRepository;
import com.alura.literalura.service.ConsumeApi;
import com.alura.literalura.service.ConvertData;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuOptionsProcessing {
    private Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://gutendex.com/books/?search=";
    private ConsumeApi consumeApi = new ConsumeApi();
    private ConvertData conversor = new ConvertData();
    private List<BookData> bookDataList = new ArrayList<>();
    private IBookRepository repository;
    private String bookTitle;

    public void processMenuOption() {
        searchBook();
    }

    /*private void searchBook() {
        try {
            BookData bookData = getBookData();
            Book book = new Book(bookData);
            repository.save(book);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Este libro ya fue registrado previamente");
        } catch (NullPointerException e) {
            System.out.println("No se encontró ningún libro con ese nombre\n");
        }
    }*/

    /*private BookData getBookData() {
        System.out.println("Ingresa el nombre de un libro para buscar: ");
        String bookTitle = sc.nextLine();
        String json = consumeApi.getData(BASE_URL + bookTitle.replace(" ", "%20"));
        BookData bookData = conversor.getData(json, BookData.class);
        return bookData;
    }*/

    private void searchBook() {
            ResultData resultData = getResults();
            if (resultData != null) {
                var bookFound = resultData.books().stream()
                        .filter((b -> b.title().equalsIgnoreCase(bookTitle)))
                        .findFirst();
                if (bookFound.isPresent()) {
                    Book book = new Book(bookFound.get().title(),
                            bookFound.get().downloadCount(),
                            bookFound.get().language());
                    System.out.println(book);
                    try {
                        //repository.save(book);
                        //System.out.println(book);
                    }  catch (DataIntegrityViolationException e) {
                        System.out.println("Este libro ya fue registrado previamente");
                    }
                }
            }
            else
                System.out.println("No se encontró ingún libro con el nombre proporcionado");
    }

    private ResultData getResults() {
        System.out.println("Ingresa el nombre de un libro para buscar: ");
        bookTitle = sc.nextLine();
        String json = consumeApi.getData(BASE_URL + bookTitle.replace(" ", "%20"));
        ResultData resultData = conversor.getData(json, ResultData.class);
        return resultData;
    }

    /*private BookData getBookData() {
        System.out.println("Ingresa el nombre de un libro para buscar: ");
        String bookTitle = sc.nextLine();
        String json = consumeApi.getData(BASE_URL + bookTitle.replace(" ", "%20"));
        BookData resultData = conversor.getData(json, BookData.class);
        return resultData;
    }*/
}
