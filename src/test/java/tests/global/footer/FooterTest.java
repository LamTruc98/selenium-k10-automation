package tests.global.footer;


import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.global.footer.FootTestFlow;
import tests.BaseTest;
import url.Urls;

public class FooterTest extends BaseTest {
    @Test
    public void testHomePageFooter() {

            driver.get(Urls.BASE_URL);
            FootTestFlow footTestFlow = new FootTestFlow(driver);
            footTestFlow.verifyFooterComponent();

    }
    @Test
    public void testRegisterPageFooter(){}

    @Test
    public void testCategoryPageFooter() {

            driver.get(Urls.BASE_URL);
        Assert.fail("demo taking screenshot when test is failed");
            FootTestFlow footTestFlow = new FootTestFlow(driver);
            footTestFlow.verifyFooterComponent();


    }

    @Test
    public void testLoginPageFooter() {
//        WebDriver driver = DriverFactory.getChromeDriver();
//        try {
//            driver.get(Urls.BASE_URL);
//            FootTestFlow footTestFlow = new FootTestFlow(driver);
//            footTestFlow.verifyFooterComponent();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            driver.quit();
//        }

    }
}
