package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMod03 {
    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginBtnSel = By.cssSelector("button[type='submit']");

    public LoginPageMod03(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageMod03 inputUsername(String username) {
        driver.findElement(usernameSel).sendKeys(username);
        return this;

    }

    public LoginPageMod03 inputpassword(String password) {
        driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public LoginPageMod03 clickOnloginBtnElem() {
        driver.findElement(loginBtnSel).click();
        return this;

    }
}
