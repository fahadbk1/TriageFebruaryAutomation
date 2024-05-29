package Day4_04152024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Selenium4DriverTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //navigate to google page
        driver.navigate().to("https://www.google.com");
        //maximize the chrome window
        driver.manage().window().maximize();
        //pause the code for 3 seconds
        Thread.sleep(3000);
        //quit the chrome browser
        driver.quit();
    }
}
