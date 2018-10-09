package rentersInsurance;

import base.CommonAPI;
import org.openqa.selenium.By;
import reporting.TestLogger;

public class RentersPropertySales extends CommonAPI {
    PropertySales objPropertySales = new PropertySales();
    public void navigteToConversation(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        objPropertySales.navigateToPropertyType();
        objPropertySales.clickOnElementRD(PropertySales.rentersRD);
    }
    public void clickOnMoving(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        navigteToConversation();
        driver.findElement(By.xpath("//button[@value='moving']")).click();
    }
}