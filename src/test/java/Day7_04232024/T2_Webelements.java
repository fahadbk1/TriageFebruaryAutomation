package Day7_04232024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_Webelements {
    public static void main(String[] args) throws InterruptedException {
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized","incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);
        //go to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //Store the yahoo headers in an array list of webelements
        ArrayList<WebElement> yahooHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class ,'_yb_jujrfs')]")));
        //print out the headers using a for loop
        for (int i = 0;i < yahooHeaders.size(); i++){
            System.out.println("Yahoo headers are " + yahooHeaders.get(i).getText());
        }//end of for loop
        //click on the sports header (should be in index 2 because its in the 3rd position)
        yahooHeaders.get(2).click();
        //wait for 2 seconds
        Thread.sleep(2000);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class
