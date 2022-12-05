package tests;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import url.Urls;

public class DemoHomePageTest implements Urls {

    @Test
    public void testFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL);

            HomePage homePage = new HomePage(driver);
            FooterComponent footerComp = homePage.footerComponent();
            InformationColumnComponent informationColumn = footerComp.informationColumnComp();
            CustomerServiceColumnComponent customerServiceColumn = footerComp.customerServiceColumnComp();
            AccountColumnComponent myAccountColumn = footerComp.accountColumnComponent();
            FollowUsColumnComponent followUsColumn = footerComp.followUsColumnComp();

            System.out.println(informationColumn.headerElem().getText());
            System.out.println(customerServiceColumn.headerElem().getText());
            System.out.println(myAccountColumn.headerElem().getText());
            System.out.println(followUsColumn.headerElem().getText());

            System.out.println(informationColumn.linksElem().isEmpty());

            // Debug purpose ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
