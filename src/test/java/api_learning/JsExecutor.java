package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import url.Urls;

public class JsExecutor implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the target page
            driver.get(BASE_URL.concat(Urls.FLOATING_MENU_SLUG));
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(javascriptExecutor);


            //Scroll to bottom
            pageHelper.scrollToBottom();
            //Debug purpose ONLY
            Thread.sleep(2000);

            //Scroll to top
            pageHelper.scrollToTop();
            //Debug purpose ONLY
            Thread.sleep(2000);

            //Go to dynamic control page
            driver.get(BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);
            pageHelper.removeElement(inputFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFormElem);

            //Debug purpose ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
