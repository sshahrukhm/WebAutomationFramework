package rentersInsuranceTest;

import rentersInsurance.PropertySales;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PropertySalesTest extends PropertySales {
    @BeforeMethod
    public void init(){
        PropertySales obj1 = PageFactory.initElements(driver, PropertySales.class);
        navigateToPropertyType();
    }
    @Test
    public void testClickOnHomeOwnersRD(){
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(homeOwnersRD));
    }
    @Test
    public void testClickOnRentersRD(){
        Assert.assertEquals("https://propertysales.geico.com/Diva/Conversation",clickOnElementRD(rentersRD));
    }
    @Test
    public void testClickOnCondoRD(){
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(condoRD));
    }
    @Test
    public void testClickOnMobileHomeRD(){
        Assert.assertEquals("https://propertysales.geico.com/MobileHome/PleaseCall",clickOnElementRD(mobileHomeRD));
    }
    @Test
    public void testClickOnLandLordRD(){
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(landLordRD));
    }
}