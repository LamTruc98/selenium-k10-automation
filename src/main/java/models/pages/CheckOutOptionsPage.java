package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOptionsPage extends BasePage {
    private final static By checkoutAsGuestSel = By.cssSelector("input[class*=\"checkout-as-guest-button\"]");

    public CheckOutOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void checkOutAsGuest() {
        findElement(checkoutAsGuestSel).click();

    }
}
