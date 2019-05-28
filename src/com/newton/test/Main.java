package com.newton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.swing.*;
import java.sql.SQLOutput;

public class Main {


    public static void main(String[] args) {

       Getinfo info = new Getinfo();
        Getprices hp= new Getprices();
        getDBschenkerPrices dbp = new getDBschenkerPrices();
        ChromeOptions options = new ChromeOptions();
        PriceList sortera = new PriceList(15.5,"default");

        options.addArguments("disable-infobars");

        WebDriver driver;

       String string = JOptionPane.showInputDialog("Skriv in postnummer dit din försändelse ska: ");
        int postnummer = Integer.parseInt(string);
        //int postnummer= info.Postnummerinfo();

PriceList pris1 = hp.getUPSPrice(postnummer, driver=new ChromeDriver(options));
PriceList pris2 =(dbp.getDBschenkerprices(postnummer, driver =new ChromeDriver(options)));
        System.out.println(pris1);
        System.out.println(pris2);
        PriceList pris3= sortera.sortdouble(pris1,pris2);

        System.out.println("Billigast:\n"+pris3);

        JOptionPane.showMessageDialog(null, pris3);
}}
