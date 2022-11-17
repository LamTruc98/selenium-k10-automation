package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod03Test implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //navigate to the target page
            driver.get(HEROKU_BASE_URL.concat(LOGIN_FORM_SLUG));

            //input login creds
            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            loginPage
                    .inputUsername("Teo")
                    .inputpassword("12345678")
                    .clickOnloginBtnElem();

            //Debug purpose Only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
