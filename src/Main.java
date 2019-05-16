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



        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement originname = driver.findElement(By.id("originname"));
        WebElement originaddress = driver.findElement(By.id("originaddress1"));
        WebElement originpostal = driver.findElement(By.id("originpostal"));
        WebElement origincity = driver.findElement(By.id("origincity"));
        WebElement originphone = driver.findElement(By.id("originphone"));
        WebElement originemail = driver.findElement(By.id("originemail"));



        originname.sendKeys(frontend.namn);
        originaddress.sendKeys(frontend.address);
        originpostal.sendKeys("18164");
        origincity.sendKeys("Stockholm");
        originphone.sendKeys("0761417766");
        originemail.sendKeys("john@gmail.com");


       // driver.findElement(By.id("nbsBackForwardNavigationContinueButton")).submit();
        driver.findElement (By.cssSelector ("#_evh-ric-c")).click ();
        driver.findElement (By.cssSelector ("#nbsBackForwardNavigationContinueButton")).click ();









    }

}
