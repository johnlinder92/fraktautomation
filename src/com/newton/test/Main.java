package com.newton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.sql.SQLOutput;

public class Main {


    public static void main(String[] args) {
        Getinfo info = new Getinfo();
        Getprices gp = new Getprices();

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1 = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options1.addArguments("disable-infobars");
        WebDriver driver;


        double price1 = gp.getUPSPrice(info.Postnummerinfo(),driver = new ChromeDriver(options) );

       double price2 = gp.getUPSPrice(info.Postnummerinfo(),driver = new FirefoxDriver(options1) );

       if(price1== price2){
           System.out.println("Samma pris, test passed"+ price1);
       }else if(price1!= price2){
           System.out.println("The price was different"+ price2+ "was different from"+price1);
       }else{
           System.out.println("Test failed");
       }


    }

}
