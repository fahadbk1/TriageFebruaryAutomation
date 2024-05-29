package Day14_05202024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class ReusableMethods_Loggers {
    public static void clickMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
        }//end of catch block
    }//end of click method

    public static String captureText(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = "";
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
            logger.log(LogStatus.PASS, "Successfully captured text from " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text from " + elementName);
        }//end of catch block
        return result;
    }//end of capture text method

    public static WebDriver setupChromeDriver() {
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");
        //pass the chrome options to the driver
        WebDriver driver = new ChromeDriver(options);
        //return driver
        return driver;
    }//end of setupdriver method

    public static void submitMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
            logger.log(LogStatus.PASS, "Successfully submitted " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL, "Unable to submit " + elementName);
        }//end of catch block
    }//end of submit method

    public static void sendKeysMethod(WebDriver driver, ExtentTest logger, String xpathValue, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully entered text on " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys on " + elementName);
        }//end of catch block
    }//end of send keys method

    public static void checkIfStringEquals(String expectedText, String actualText, ExtentTest logger) {
        if (expectedText.equals(actualText)) {
            logger.log(LogStatus.PASS, "Expected Text " + expectedText + " Matches " + actualText);

        } else {
            logger.log(LogStatus.FAIL, "Expected Text " + expectedText + " does not match " + actualText);
        }
    }//end of checkString
}
