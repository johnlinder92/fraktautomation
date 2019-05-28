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
    public void Demotest_run3postalcodes_showcheapestprice() {

        // visar billigast pris med postnummer från Stockholm, Göteborg, Malmö

        PriceList pl = new PriceList(10.0, "Default");
        Getprices gp = new Getprices();
        getDBschenkerPrices dbs = new getDBschenkerPrices();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");

        WebDriver driver;

        PriceList pris1 = gp.getUPSPrice(18164, driver= new ChromeDriver(options));
        PriceList pris2 = dbs.getDBschenkerprices(18164, driver= new ChromeDriver(options));
        System.out.println(pris1);
        System.out.println(pris2);
        System.out.println("Billigast:"+pl.sortdouble(pris1, pris2));

        PriceList pris3 = gp.getUPSPrice(41650, driver= new ChromeDriver(options));
        PriceList pris4 = dbs.getDBschenkerprices(41650, driver= new ChromeDriver(options));
        System.out.println(pris3);
        System.out.println(pris4);
        System.out.println("Billigast:"+pl.sortdouble(pris1, pris2));

        PriceList pris5 = gp.getUPSPrice(21146, driver= new ChromeDriver(options));
        PriceList pris6 = dbs.getDBschenkerprices(21146, driver= new ChromeDriver(options));
        System.out.println(pris5);
        System.out.println(pris6);
        System.out.println("Billigast:"+pl.sortdouble(pris1, pris2));




    }



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