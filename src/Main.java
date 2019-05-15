import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
public class Main {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables

        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Fraktautomatition- The Humble Co\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.ups.com/ship/guided/origin?tx=4650480306877647&loc=en_SE";


        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);








    }

}
