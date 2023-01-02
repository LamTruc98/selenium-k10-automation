package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    public static WebDriver getChromeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignored");

        WebDriver driver = new ChromeDriver(chromeOptions);

        //Interval time| 500 mili seconds = 0.5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));

        return driver;

    }

    public WebDriver getDriver(String browserName) {
        if (driver == null) {
            switch (browserName) {
                case ("chrome"):
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException(browserName + " is not supported!");
            }
        }
        return driver;
    }

    public void closeBrowserSession() {
        if (driver != null) {
            driver.quit();
        }
    }

}
