package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
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
        boolean isRemoteRunning = System.getProperty("hub") != null;
        if(isRemoteRunning) return getRemoteWebDriver(browserName, System.getProperty("hub"));
        else return getLocalDriver(browserName);

    }

    private WebDriver getLocalDriver(String browserName) {
        if(driver == null) {
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

    private WebDriver getRemoteWebDriver(String browserName, String hub) {
        if(driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            switch (browserName) {
                case ("chrome"):
                    desiredCapabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    desiredCapabilities.setBrowserName("firefox");
                    break;
                case "safari":
                    desiredCapabilities.setBrowserName("safari");
                    break;
                default:
                    throw new IllegalArgumentException(browserName + " is not supported!");
            }

            try {
                URL hubUrl = new URL(hub.concat("/wd/hub"));
                driver = new RemoteWebDriver(hubUrl, desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
            } catch (Exception e){
                e.printStackTrace();
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
