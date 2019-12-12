package com.newton.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class GetDHLprice {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    public PriceList getDHLprice(String postnummer, WebDriver driver) {
        driver.get("https://mydhl.express.dhl/se/en/shipment.html#/rate-and-quote?fromAddressLine=&toCountry=SE&shipmentFromDashboard=true#address-details");
       // driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Björkudssvägen 17");
        driver.findElement(By.xpath("(//input[@type=\'text\'])[3]")).sendKeys(postnummer);
        driver.findElement(By.name("city")).sendKeys("Lidingoe");
        driver.findElement(By.cssSelector(".field-wrapper:nth-child(2) > .ng-ams-configuration-pending")).click();
        driver.findElement(By.cssSelector(".col-5:nth-child(4) .row > .form-row .input")).sendKeys("Toredalsgatan 24");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(5) > .row")).click();
        driver.findElement(By.cssSelector(".form-row > .field-wrapper > .ng-invalid-ewf-valid")).click();
        driver.findElement(By.cssSelector(".col-5:nth-child(4) .col-3 .input")).sendKeys("40180");
        driver.findElement(By.cssSelector(".field-wrapper > .ng-invalid-ewf-valid")).click();
        driver.findElement(By.className("btn-close")).click();
        driver.findElement(By.cssSelector(".col-5:nth-child(4) .col-5 .input")).sendKeys("GOETEBORG");
        driver.findElement(By.cssSelector(".field-wrapper:nth-child(2) > .ng-ams-configuration-pending")).click();
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector(".col-5:nth-child(4) .ng-scope > .row > .col-4"));
        action.moveToElement(we).build().perform();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector("stepCtrl.nextButtonText")).click();
        driver.findElement(By.cssSelector(".col-5:nth-child(4) .ng-scope > .row > .col-4")).click();
        driver.findElement(By.cssSelector(".area__footer > .btn")).click();
        driver.findElement(By.cssSelector(".col-6:nth-child(2) .switcher__label")).click();
        driver.findElement(By.cssSelector(".inline-block")).click();
        driver.findElement(By.name("weight")).sendKeys("10");
        driver.findElement(By.name("length")).sendKeys("50");
        driver.findElement(By.name("width")).sendKeys("40");
        driver.findElement(By.name("height")).sendKeys("25");
        driver.findElement(By.name("contentForm")).click();
        driver.findElement(By.cssSelector(".area__footer > .btn")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".area__footer > .btn"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".ng-scope:nth-child(4) .delivery-options__info .ng-isolate-scope")).click();
        PriceList test = new PriceList(0, "Test");
        return test;

    }
}