package models.pages;

import models.components.LoginFormComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMod03 extends BasePage {
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginBtnSel = By.cssSelector("button[type='submit']");

    public LoginPageMod03(WebDriver driver) {
        super(driver);
    }

    public LoginPageMod03 inputUsername(String username) {
        driver.findElement(usernameSel).sendKeys(username);
        return this;

    }

    public LoginPageMod03 inputPassword(String password) {
        driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public LoginPageMod03 clickOnLoginBtn() {
        driver.findElement(loginBtnSel).click();
        return this;

    }
    public LoginFormComponent loginFormComponent() {
        return findComponent(LoginFormComponent.class, driver);
    }
}
