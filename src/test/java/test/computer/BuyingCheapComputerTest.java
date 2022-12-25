package test.computer;

import models.components.orders.CheapComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.CreditCardType;
import test_data.PaymentMethodType;
import test_data.computer.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.computer.OrderComputerFlow;
import url.Urls;

import java.security.SecureRandom;

public class BuyingCheapComputerTest extends BaseTest implements Urls {

    @Test(dataProvider = "computerData")
    public void testCheapComputerBuying(ComputerData computerData) {
        WebDriver driver = getDriver();

        driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));
        int randomQuantity = new SecureRandom().nextInt(100) + 2;
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData, randomQuantity);
        orderComputerFlow.buildCompSpecAndAddToCart();
        orderComputerFlow.verifyShoppingCartPage();
        orderComputerFlow.agreeTOSAndCheckOut();
        orderComputerFlow.inputBillingAddress();
        orderComputerFlow.inputShippingAddress();
        orderComputerFlow.selectShippingMethod();
        orderComputerFlow.selectPaymentMethod(PaymentMethodType.CREDIT_CARD);
        orderComputerFlow.inputPaymentInfo(CreditCardType.DISCOVER);
        orderComputerFlow.confirmOrder();
    }

    @DataProvider
    public ComputerData[] computerData() {
        String fileLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}
