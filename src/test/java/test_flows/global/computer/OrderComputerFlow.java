package test_flows.global.computer;

import models.components.orders.ComputerEssentialComponent;
import models.pages.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow <T extends ComputerEssentialComponent> {
    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent) {
        this.driver = driver;
        this.computerEssentialComponent=computerEssentialComponent;
    }
    public void buildComputerSpecAndAddToCard(){
        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        T computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialComponent);
        computerEssentialComp.selectProcessorType("2.5GHz");
        computerEssentialComp.selectRAMType("2GB");


    }{
}
