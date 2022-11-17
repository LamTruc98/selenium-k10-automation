package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#login")
public class LoginFormComponent extends Component {
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginBtnSel = By.cssSelector("button[type='submit']");

    public LoginFormComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement usernameElem() {
        return driver.findElement(usernameSel);

    }

    public WebElement passwordElem() {
        return driver.findElement(passwordSel);

    }

    public WebElement loginBtnElem() {
        return driver.findElement(loginBtnSel);

    }
}
