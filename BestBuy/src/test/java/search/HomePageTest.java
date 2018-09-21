package search;

import base.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends HomePage {
    //TC#1 => User is verifying that he is on the right page
    @Test
    public void verifyEbay() {
        boolean expected = true;
        boolean actual = driver.findElement((By.cssSelector("#gh-logo"))).isDisplayed();
        System.out.println(actual);

        Assert.assertEquals(actual, expected);
    }


    // TC#2 User is registering/signing up for eBay
    /*@Test
    public  void signUpForeBay() {
        clickOnCss("#gh-ug-flex > a");

        //typing the first name on the FirstName field

        typeByCss("#firstname", "Shaikh");

        // typing the last name on the FirstName field

        typeByCss("#lastname","Muhammad");

        // typing the last name on the FirstName field

        typeByCss("#email","shahrukh.mu@gmail.com");

        // typing the last name on the FirstName field

        typeByCss("#PASSWORD","shahrukh0123");

        // Click on Create account Button
        waitUntilClickAble(By.cssSelector("#ppaFormSbtBtn"));
        clickOnCss("#ppaFormSbtBtn");*/

    private void clickOnCss(String s) {
    }
}
