package test_flows.global.footer;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootTestFlow {
    private final WebDriver driver;

    public FootTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        Assert.fail();
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComponent = basePage.footerComponent();

        InformationColumn informationColumn = footerComponent.informationColumn();
        CustomerServiceColumn customerServiceColumn = footerComponent.customerServiceColumn();
        MyAccountColumn myAccountColumn = footerComponent.myAccountColumn();
        FollowUsColumn followUsColumn = footerComponent.followUsColumn();

        verifyInformationColumn(informationColumn);
        verifyCustomerServiceColumn(customerServiceColumn);
        verifyMyAccountColumn(myAccountColumn);
        verifyFollowUsColumn(followUsColumn);


    }

    private void verifyInformationColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkText = Arrays.asList(
                "Sitemap",
                "Shipping & Returns",
                "Privacy Notice",
                "Conditions of Use",
                "About us",
                "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/sitemap",
                "https://demowebshop.tricentis.com/shipping-returns",
                "https://demowebshop.tricentis.com/privacy-policy",
                "https://demowebshop.tricentis.com/conditions-of-use",
                "https://demowebshop.tricentis.com/about-us",
                "https://demowebshop.tricentis.com/contactus"
        );
        verifyFooterColumn(footerColumnComponent, expectedLinkText, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkText = Arrays.asList(
                "Search",
                "News",
                "Blog",
                "Recently viewed products",
                "Compare products list",
                "New products");
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/search",
                "https://demowebshop.tricentis.com/news",
                "https://demowebshop.tricentis.com/blog",
                "https://demowebshop.tricentis.com/recentlyviewedproducts",
                "https://demowebshop.tricentis.com/compareproducts",
                "https://demowebshop.tricentis.com/newproducts");
        verifyFooterColumn(footerColumnComponent, expectedLinkText, expectedHrefs);
    }

    private void verifyMyAccountColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkText = Arrays.asList("My account",
                "Orders",
                "Addresses",
                "Shopping cart",
                "Wishlist");
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/customer/info",
                "https://demowebshop.tricentis.com/customer/orders",
                "https://demowebshop.tricentis.com/customer/addresses",
                "https://demowebshop.tricentis.com/cart",
                "https://demowebshop.tricentis.com/wishlist");
        verifyFooterColumn(footerColumnComponent, expectedLinkText, expectedHrefs);
    }

    private void verifyFollowUsColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkText = Arrays.asList("Facebook",
                "Twitter",
                "RSS",
                "YouTube",
                "Google+");
        List<String> expectedHrefs = Arrays.asList(
                "http://www.facebook.com/nopCommerce",
                "https://twitter.com/nopCommerce",
                "https://demowebshop.tricentis.com/news/rss/1",
                "http://www.youtube.com/user/nopCommerce",
                "https://plus.google.com/+nopcommerce");
        verifyFooterColumn(footerColumnComponent, expectedLinkText, expectedHrefs);
    }

    private void verifyFooterColumn(
            FooterColumnComponent footerColumnComponent, List<String> expectedLinkText, List<String> expectedHrefs) {
        List<String> actualLinkText = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        if (footerColumnComponent.linkElem().isEmpty())
            Assert.fail("The column has no item to test");
        for (WebElement link : footerColumnComponent.linkElem()) {
            actualLinkText.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));

        }
        if (actualHrefs.isEmpty() || actualLinkText.isEmpty())
            Assert.fail("[ERR] texts or hyperlink is empty in the footer column");
        //verify link text

        Assert.assertEquals(actualLinkText, expectedLinkText, "[ERR] Link text list is mismached!");
        //verify hyperlinks
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Hyperlink text list is mismached!");

    }
}
