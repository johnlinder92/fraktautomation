package com.newton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Main extends Thread{


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsoleHandler ch = new ConsoleHandler(scanner);
       Getinfo info = new Getinfo();
        GetUpsPrice ups = new GetUpsPrice();
       getDBschenkerPrice dbs = new getDBschenkerPrice();
       GetDHLprice dhl = new GetDHLprice();
        ChromeOptions options = new ChromeOptions();
        PriceList sortera = new PriceList(15.5,"default");

        options.addArguments("disable-infobars");

        WebDriver driver;
        WebDriver driver2;
       // WebDriver driver3;



       String postnummer = ch.getString("Skriv in postnummer dit din försändelse ska:");

        //int postnummer= info.Postnummerinfo();


 PriceList pris1 = dbs.getDBschenkerprices(postnummer, driver = new ChromeDriver(options));
PriceList pris2 = ups.getUPSPrice(postnummer, driver2 = new ChromeDriver(options));
//PriceList pris3 =dhl.getDHLprice(postnummer, driver3 =new ChromeDriver(options));

       PriceList[] prislista = {pris1,pris2};
       System.out.println("Alla Bolag:");
       pris1.printArray(prislista);
       PriceList[] sorteradlista = pris1.Bubblesort(prislista);

        System.out.println("Sorterat meh bouble sort:");
        pris1.printArray(sorteradlista);


        System.out.println(sorteradlista);
}}
