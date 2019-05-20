package com.newton.test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleHandler {
    private Scanner scanner;

    public ConsoleHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getInt(String s) {
        System.out.println(s);
        int tal = 0;


        try {

            tal = Integer.parseInt(scanner.nextLine());

        } catch (InputMismatchException e) {

            System.out.println("Felaktig inmatning!");

        }
        catch(NumberFormatException a){

            System.out.println("Felaktig inmatning!");

        }

        return tal;

    }

    public String getString(String s) {
        System.out.println(s);
        String text = "";

        try {
            text = scanner.nextLine();

        } catch (NoSuchElementException e) {

            System.out.println("Felaktig inmatning!");

        }

        return text;

    }


}