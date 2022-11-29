package test_flows.global.computer;

import models.components.orders.ComputerEssentialComponent;
import models.pages.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {
    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
    }

    public void buildComputerSpecAndAddToCart() {
        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        T computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialComponent);
        computerEssentialComp.selectProcessorType("Fast");
        computerEssentialComp.selectRAMType("4GB");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }

}
