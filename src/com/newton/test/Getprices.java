package com.newton.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Getprices {

    public float getUpsPrice(int postnummer){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);

    JavascriptExecutor js = ((JavascriptExecutor) driver);
//
    String baseUrl = "https://www.ups.com/ship/guided/origin?tx=4650480306877647&loc=en_SE";
//
//
    driver.get(baseUrl);
//
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    WebElement originname = driver.findElement(By.id("originname"));
    WebElement originaddress = driver.findElement(By.id("originaddress1"));
    WebElement originpostal = driver.findElement(By.id("originpostal"));
    WebElement origincity = driver.findElement(By.id("origincity"));
    WebElement originphone = driver.findElement(By.id("originphone"));
    WebElement originemail = driver.findElement(By.id("originemail"));



        originname.sendKeys("defaultname");
        originaddress.sendKeys("defaultaddress");
        originpostal.sendKeys("41877");
        origincity.sendKeys("Stockholm");
        originphone.sendKeys("0761417766");
        originemail.sendKeys("john@gmail.com");


    // driver.findElement(By.id("nbsBackForwardNavigationContinueButton")).submit();
        driver.findElement (By.cssSelector ("#_evh-ric-c")).click ();
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    WebElement destinationname = driver.findElement(By.id("destinationname"));
    WebElement destinationaddress = driver.findElement(By.id("destinationaddress1"));
    WebElement destinationpostal = driver.findElement(By.id("destinationpostal"));
    WebElement destinationcity = driver.findElement(By.id("destinationcity"));

        destinationname.sendKeys("defaultname");
        destinationaddress.sendKeys("defaultaddress");
        destinationpostal.sendKeys(String.valueOf(postnummer));
        destinationcity.sendKeys("Stockholm");

        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();

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
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();



        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        driver.findElement (By.id("nbsBalanceBarExpandButton")).click ();


       // js.executeScript("window.scrollBy(0,750)", "");
   // WebElement expresssaverprice = driver.findElement(By.id("nbsServiceTileTotalCharge0_0_1"));
  //  WebElement expressprice = driver.findElement(By.id("nbsServiceTileTotalCharge0_0_0"));
    //WebElement pris = driver.findElement(By.id("total-charges-spinner"));
//    WebElement priset1 = driver.findElement(By.id("$0"));



  //      js.executeScript("window.scrollBy(0,650)", "");

   //   driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();






        //String text = driver.findElement(By.cssSelector("#nbsBalanceBarTotalCharges")).getText();


      // String priset = priset1.getAttribute("$0");


        //String prisesss = pris.getAttribute("_ngcontent-c1").toString();

    //    js.executeScript("window.scrollBy(0,60)", "");


    //    driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();


        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement test = driver.findElement(By.id("nbsPickupServicePageShipmentServices"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", test);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement (By.id("nbsServiceTileServiceDescription0_0_0")).isSelected ();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("nbsServiceTileServiceDescription0_0_0")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement test2 = driver.findElement(By.id("nbsServiceTileServiceDescription0_0_0"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", test2);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).isSelected ();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).isSelected();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        String pris1 = driver.findElement(By.cssSelector("#total-charges-spinner")).getText();








        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String testet = pris1.replace(".","");
        String testet2 = testet.replace(",",".");



        float pris = Float.parseFloat(testet2.substring(2));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.close();

        return pris;


}
}
