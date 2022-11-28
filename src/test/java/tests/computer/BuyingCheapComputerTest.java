package tests.computer;

import models.components.orders.CheapComputerComponent;
import models.components.orders.ComputerEssentialComponent;
import models.pages.BasePage;
import models.pages.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.computer.OrderComputerFlow;
import url.Urls;

public class BuyingCheapComputerTest extends BasePage implements Urls {
 @Test
    public void testCheapComputerBuy(){
     driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));
     OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class);
     orderComputerFlow.buildComputerSpecAndAddToCard();
 }
}
