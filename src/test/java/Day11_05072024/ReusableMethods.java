package Day11_05072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {
    public static void clickMethod(WebDriver driver, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).click();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " due to exception " + e);
        }//end of catch block
    }//end of click method

    public static String captureText(WebDriver driver, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result ="";
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
        }//end of catch block
        return result;
    }//end of capture text method

   public static WebDriver setupChromeDriver(){
       //declare and define chrome options
       ChromeOptions options = new ChromeOptions();
       //add option to start it maximized
       options.addArguments("start-maximized","incognito");
       //pass the chrome options to the driver
       WebDriver driver = new ChromeDriver(options);
       //return driver
       return driver;
   }//end of setupdriver method

    public static void submitMethod(WebDriver driver, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " due to exception " + e);
        }//end of catch block
    }//end of submit method

    public static void sendKeysMethod(WebDriver driver, String xpathValue, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(userInput);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
        }//end of catch block
    }//end of send keys method

}//end of class
