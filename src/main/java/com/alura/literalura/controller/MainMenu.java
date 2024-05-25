package com.alura.literalura.controller;

import com.alura.literalura.view.Main;

import java.util.Scanner;

public class MainMenu {
    private Scanner sc = new Scanner(System.in);
    private ValidateMenuOptions menuOptions = new ValidateMenuOptions();
    private Main main = new Main();


    public void showMainMenu() {
        String option = "";
        do {
            System.out.println(main.getMainMenu());
            System.out.print("Ingrese la opción deseada: ");
            menuOptions.setOptionInteger(sc.nextLine());
            if (menuOptions.validateIntegerOption())
                chooseOption(menuOptions.getOptionInteger());
        } while (!option.equals("0"));
    }

    private void chooseOption(Integer option) {
        MenuOptionsProcessing processing = new MenuOptionsProcessing();
        switch (menuOptions.getOptionInteger()) {
            case 1:
                processing.processMenuOption();
                break;
            case 0:
                System.out.println("Hasta pronto");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida\n");
        }
    }
}