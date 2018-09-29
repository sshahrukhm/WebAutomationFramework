package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationBar;

public class NavigationBarTest extends NavigationBar {
    NavigationBar n1;
    @BeforeMethod
    public void init(){
        n1 = PageFactory.initElements(driver, NavigationBar.class);
    }

    @Test
    public void testClickInsurance() throws InterruptedException {
        boolean retStatement = clickOnInsurance();;
        Assert.assertEquals(true,retStatement);
    }
    @Test
    public void testClickInformation() throws InterruptedException {
        boolean retStatement = clickOnInformation();
        Assert.assertEquals(true,retStatement);
    }
    @Test
    public void testClickLocation()throws InterruptedException {
        boolean retStatement = clickOnLocationIcon();
        Assert.assertEquals(true,retStatement);
    }
    @Test
    public void testClickLogin()throws InterruptedException{
        boolean retStatement = clickLogin();;
        Assert.assertEquals(true,retStatement);
    }
    @Test
    public void testClickSearchIcon()throws InterruptedException{
        boolean retStatement = clickOnSearchIcon();
        Assert.assertEquals(true,retStatement);
    }
    @Test
    public void testClickOnGeicoLogo()throws InterruptedException{
        String url = clickOnGeicoLogo();
        Assert.assertEquals("https://www.geico.com/",url);
    }

}
