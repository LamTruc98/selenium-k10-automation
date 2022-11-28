package models.pages;

import models.components.orders.ComputerEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailPage extends BasePage {
    public ComputerItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public <T extends ComputerEssentialComponent> T computerComp(Class<T> computerEssentialCompClass) {
        return findComponent(computerEssentialCompClass, driver);
    }
}
