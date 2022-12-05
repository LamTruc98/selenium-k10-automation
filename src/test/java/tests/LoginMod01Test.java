package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod01Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to the target page
            driver.get(HEROKU_BASE_URL.concat(LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.username().sendKeys("Teo");
            loginPage.password().sendKeys("12345678");
            loginPage.loginBtn().click();

            // Debug purpose ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
