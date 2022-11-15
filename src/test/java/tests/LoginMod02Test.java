package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod02Test implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login creds
            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("Teo");
            loginPage.inputpassword("12345678");
            loginPage.clickOnloginBtnElem();

            //Debug purpose Only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
