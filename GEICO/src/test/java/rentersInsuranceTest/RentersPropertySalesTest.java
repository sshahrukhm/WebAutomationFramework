package rentersInsuranceTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rentersInsurance.RentersPropertySales;

public class RentersPropertySalesTest extends RentersPropertySales {
    @BeforeMethod
    public void init(){
        RentersPropertySales obj = PageFactory.initElements(driver,RentersPropertySales.class);
        navigteToConversation();
    }
    @Test
    public void testMovingClick(){
        clickOnMoving();
    }
}