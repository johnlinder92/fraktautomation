import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables

        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Fraktautomatition- The Humble Co\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Frontend frontend = new Frontend();
        String baseUrl = "https://www.ups.com/ship/guided/origin?tx=4650480306877647&loc=en_SE";

        frontend.fyllInformation();

        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

        WebElement destinationname = driver.findElement(By.id("destinationname"));
        WebElement destinationaddress = driver.findElement(By.id("destinationaddress1"));
        WebElement destinationpostal = driver.findElement(By.id("destinationpostal"));
        WebElement destinationcity = driver.findElement(By.id("destinationcity"));

        destinationname.sendKeys("defaultname");
        destinationaddress.sendKeys("defaultaddress");
        destinationpostal.sendKeys(frontend.postNr);
        destinationcity.sendKeys("Stockholm");

        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();

     //   id="nbsPackagePackageWeightField0"
     //        id="nbsPackagePackageLengthField0"
     //       id="nbsPackagePackageWidthField0"


    }

}
