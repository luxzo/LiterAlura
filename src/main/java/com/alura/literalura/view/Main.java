package com.alura.literalura.view;

import com.alura.literalura.controller.MainMenu;

public class Main {
    private String mainMenu = """
            1. Buscar libro por título
            2. Listar libros registrados
            3. Listar autores registrados
            4. Listar autores vivos en un determinado año
            5. Listar libros por idioma
            0. Salir
            """;

    public void showMainMenu() {
        System.out.println("\n***********************************************");
        System.out.println("*********** Bienvenido a LiterAlura ***********");
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMainMenu();
    }

    public String getMainMenu() {
        return mainMenu;
    }
}
