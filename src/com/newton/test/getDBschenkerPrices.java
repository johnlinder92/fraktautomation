package com.newton.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class getDBschenkerPrices {

    public void getDBschenkerprices(int postnummer){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
//
        String baseUrl = "https://skicka2.dbschenker.com/bobweb-prod-201905090829/index.html";
//
//

        driver.get(baseUrl);

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalSender")));

        WebElement test5 = driver.findElement(By.id("weight"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", test5);

        WebElement originpostalFrom = driver.findElement(By.id("postalSender"));
        WebElement orginpostalTo = driver.findElement(By.id("postalReceiver"));

        originpostalFrom.sendKeys("41870");
        orginpostalTo.sendKeys(String.valueOf(postnummer));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement test4 = driver.findElement(By.id("senderFieldName"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", test4);

        WebElement senderName = driver.findElement(By.id("senderFieldName"));
        senderName.sendKeys("defaultaddress");
        WebElement senderAddress = driver.findElement(By.id("senderFieldAddress"));
        senderAddress.sendKeys("defauladdress");
        WebElement senderCode = driver.findElement(By.id("senderFieldCode"));
        senderCode.sendKeys("1");
        WebElement senderCompany = driver.findElement(By.id("senderFieldCompany"));
        senderCompany.sendKeys("defaultCompany");
        WebElement senderEmail = driver.findElement(By.id("senderFieldEmail"));
        senderEmail.sendKeys("default@email.com");
        WebElement senderPhone = driver.findElement(By.id("senderFieldPhone"));
        senderPhone.sendKeys("0700000000");




        /*String pris1 = driver.findElement(By.cssSelector("#total-charges-spinner")).getText();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String testet = pris1.replace(".", "");
        String testet2 = testet.replace(",", ".");


        double pris = Double.parseDouble(testet2.substring(2));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.close();

        return pris;*/







    }}
