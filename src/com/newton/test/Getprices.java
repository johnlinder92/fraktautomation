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

public class Getprices {

    public float getUpsPrice(int postnummer) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
//
        String baseUrl = "https://www.ups.com/ship/single-page?tx=9805560833583904&loc=en_SE";
//
//

        driver.get(baseUrl);

        driver.manage().window().maximize();


////
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement originname = driver.findElement(By.id("originname"));
        WebElement originaddress = driver.findElement(By.id("originaddress1"));
        WebElement originpostal = driver.findElement(By.id("originpostal"));
        WebElement origincity = driver.findElement(By.id("origincity"));
        WebElement originphone = driver.findElement(By.id("originphone"));
        WebElement originemail = driver.findElement(By.id("originemail"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        originname.sendKeys("defaultname");
        originaddress.sendKeys("defaultaddress");
        originpostal.sendKeys("41877");
        origincity.sendKeys("Stockholm");
        originphone.sendKeys("0761417766");
        originemail.sendKeys("john@gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // driver.findElement(By.id("nbsBackForwardNavigationContinueButton")).submit();
        driver.findElement(By.cssSelector("#_evh-ric-c")).click();
        driver.findElement(By.cssSelector("#nbsBackForwardNavigationContinueButton")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement destinationname = driver.findElement(By.id("destinationname"));
        WebElement destinationaddress = driver.findElement(By.id("destinationaddress1"));
        WebElement destinationpostal = driver.findElement(By.id("destinationpostal"));
        WebElement destinationcity = driver.findElement(By.id("destinationcity"));

        destinationname.sendKeys("defaultname");
        destinationaddress.sendKeys("defaultaddress");
        destinationpostal.sendKeys(String.valueOf(postnummer));
        destinationcity.sendKeys("Stockholm");

        driver.findElement(By.cssSelector("#nbsBackForwardNavigationContinueButton")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement weight = driver.findElement(By.id("nbsPackagePackageWeightField0"));
        WebElement length = driver.findElement(By.id("nbsPackagePackageLengthField0"));
        WebElement widht = driver.findElement(By.id("nbsPackagePackageWidthField0"));
        WebElement height = driver.findElement(By.id("nbsPackagePackageHeightField0"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        weight.sendKeys("10");
        length.sendKeys("50");
        widht.sendKeys("40");
        height.sendKeys("25");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,750)", "");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#nbsBackForwardNavigationContinueButton")).click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nbsServiceTileServiceDescription0_0_0")));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nbsPickupServicePageShipmentServices")));
        WebElement test = driver.findElement(By.id("nbsPickupServicePageShipmentServices"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", test);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nbsServiceTileServiceDescription0_0_0")));
        driver.findElement(By.id("nbsServiceTileServiceDescription0_0_0")).isSelected();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nbsServiceTileServiceDescription0_0_0")));
        driver.findElement(By.id("nbsServiceTileServiceDescription0_0_0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nbsServiceTileTotalCharge0_0_0")));
        WebElement test2 = driver.findElement(By.cssSelector("#nbsServiceTileTotalCharge0_0_0"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", test2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nbsBackForwardNavigationContinueButton")));
        driver.findElement(By.cssSelector("#nbsBackForwardNavigationContinueButton")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nbsOptionsPageShipmentOptions")));






        String pris1 = driver.findElement(By.cssSelector("#total-charges-spinner")).getText();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String testet = pris1.replace(".", "");
        String testet2 = testet.replace(",", ".");


        float pris = Float.parseFloat(testet2.substring(2));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       // driver.close();

        return pris;


    }
}
