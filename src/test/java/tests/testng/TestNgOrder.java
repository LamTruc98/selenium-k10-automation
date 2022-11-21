package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Verifier;

public class TestNgOrder {
    @Test(dependsOnMethods = {"testB"})
    public void testA(){
        System.out.println("testA");
    }
    @Test()
    public void testB(){
        System.out.println("testB");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1,2, "[ERR] faile in the field ....");
        softAssert.assertEquals(1,1);
        softAssert.assertAll();
        System.out.println("Hello");



    }
}
