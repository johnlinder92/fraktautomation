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

        getDBschenkerPrices dbp = new getDBschenkerPrices();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");

        WebDriver driver;
        dbp.getDBschenkerprices(info.Postnummerinfo());

    }

}
