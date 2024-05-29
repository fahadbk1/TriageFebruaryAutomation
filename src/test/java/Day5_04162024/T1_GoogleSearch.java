package Day5_04162024;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver variable and set up the chrome driver
        WebDriver driver = new ChromeDriver();
        //go to google.com
        driver.navigate().to("https://www.google.com");
        //type cars in the search box
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
        //click or submit the google search button
        driver.findElement(By.xpath("//*[@name = 'btnK']")).submit();
        //pause for 2 seconds
        Thread.sleep(2000);
        //store the search result into a string variable
        String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
        //print out the result stats
        System.out.println("Search Result is " + searchResult);
        //quit the chrome browser
        driver.quit();
    }//end of main
}//end of class
