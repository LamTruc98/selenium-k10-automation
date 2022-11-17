package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormInteraction {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");
            //Define selector values
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("button[type='submit']");

            //find elements

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            //interact with elements
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");

            //Refresh page then re-input
            driver.navigate().refresh();
            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginBtnElem = driver.findElement(loginBtnSel);
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            //User Dashboard page
            By headingSel = By.cssSelector("h2_taolao");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(headingSel)));

            WebElement headingElem = driver.findElement(headingSel);
            System.out.println("Heading Title: " + headingElem.getText());

            //Find by link text, partial Link Text
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
            System.out.println(driver.findElement(By.partialLinkText("Elemental")).getText());
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

            //Debug purpose ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
