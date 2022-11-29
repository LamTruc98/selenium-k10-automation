package tests.computer;

import models.components.orders.StandardComputerComponent;
import org.testng.annotations.Test;
import test_flows.global.computer.OrderComputerFlow;
import tests.BaseTest;
import url.Urls;

public class BuyingStandardComponent extends BaseTest implements Urls {
    @Test
    public void testCheapComputerBuying() {
        driver.get(BASE_URL.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent .class);
        orderComputerFlow.buildComputerSpecAndAddToCart();
    }


}
