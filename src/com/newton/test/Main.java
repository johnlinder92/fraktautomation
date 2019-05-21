package com.newton.test;

public class Main {


    public static void main(String[] args) {
        Getinfo info = new Getinfo();
        Getprices gp = new Getprices();

        System.out.println(gp.getUpsPrice(info.Postnummerinfo()));

    }

}