import com.newton.test.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.prefs.PreferenceChangeEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    @Test
    public void testTwoDifferentBrowsers_ComparePrices_ExpectSamePriceUPS() {


        Getinfo info = new Getinfo();
        Getprices gp = new Getprices();

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1 = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options1.addArguments("disable-infobars");
        WebDriver driver;
        double a = Math.random();
        double multi = 100000;


        int priset1 = (int) (10000 + a * (multi - 10000));


        PriceList price1 = gp.getUPSPrice(priset1, driver = new ChromeDriver(options));

        PriceList price2 = gp.getUPSPrice(priset1, driver = new FirefoxDriver(options1));

        if (price1.getPrice() == price2.getPrice()) {
            System.out.println("Samma pris, test passed" + price1);
        } else if (price1.getPrice() != price2.getPrice()) {
            System.out.println("The price was different" + price2 + "was different from" + price1);
        } else {
            System.out.println("Test failed");
        }
    }

    @Test
    public void testTwoDifferentBrowsers_ComparePrices_ExpectSamePrice_DBS() {


        Getinfo info = new Getinfo();
        getDBschenkerPrices DBS = new getDBschenkerPrices();

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1 = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options1.addArguments("disable-infobars");
        WebDriver driver;
        double a = Math.random();
        double multi = 100000;


        int priset1 = (int) (10000 + a * (multi - 10000));


       PriceList price1 = DBS.getDBschenkerprices(priset1, driver = new ChromeDriver(options));

        PriceList price2 = DBS.getDBschenkerprices(priset1, driver = new FirefoxDriver(options1));

        if (price1.getPrice() == price2.getPrice()) {
            System.out.println("Samma pris, test passed" + price1);
        } else if (price1.getPrice() != price2.getPrice()) {
            System.out.println("The price was different" + price2 + "was different from" + price1);
        } else {
            System.out.println("Test failed");
        }


    }
}