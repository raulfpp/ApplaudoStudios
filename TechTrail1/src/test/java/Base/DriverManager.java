package Base;//Driver manager
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver chromeDriver;

    public static WebDriver getCleanDriver(){
        if (chromeDriver == null){
            WebDriverManager.chromedriver().setup();
            //Opciones
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("disable-infobars");
            //options.addArguments("--headless");
            chromeDriver = new ChromeDriver(options);
        }
        chromeDriver.manage().deleteAllCookies();
        chromeDriver.get("http://automationpractice.com/index.php");
        return chromeDriver;
    }

    @AfterSuite
    public static void closeDriver(){
        if (chromeDriver != null) {
            chromeDriver.close();
            chromeDriver = null;
        }
    }


}
