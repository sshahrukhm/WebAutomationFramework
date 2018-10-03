package rentersInsurance;

import base.CommonAPI;
import org.openqa.selenium.By;

public class RentersPropertySales extends CommonAPI {
    PropertySales objPropertySales = new PropertySales();
    public void navigteToConversation(){
        objPropertySales.clickOnElementRD(PropertySales.rentersRD);
    }
    public void clickOnMoving(){
        driver.findElement(By.xpath("//button[@value='moving']")).click();
    }
}