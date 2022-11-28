package models.components.orders;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailComponents extends Component {
    private final static By productPriceSel = By.cssSelector(".product-price");
    public BaseItemDetailComponents(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public double productPrice(){
       String productPriceText = component.findElement(productPriceSel).getText().trim();
       return  Double.parseDouble(productPriceText);
    }
}
