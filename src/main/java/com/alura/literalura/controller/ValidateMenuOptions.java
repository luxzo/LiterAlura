package com.alura.literalura.controller;

public class ValidateMenuOptions {
    private Integer optionInteger;
    public boolean validateIntegerOption() {

//        try {
//            optionInteger = Integer.valueOf(option);
//            return true;
//        } catch (NumberFormatException e) {
//            System.out.println("Opción no válida");
//        }
//        return false;
//        assertTrue()
        if (optionInteger instanceof Integer)
            return true;
        return false;
    }

    public int getOptionInteger() {
        return optionInteger;
    }

    public void setOptionInteger(String option) {
        try {
            this.optionInteger = Integer.valueOf(option);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese solo números, intente nuevamente\n");
        }
    }
}
