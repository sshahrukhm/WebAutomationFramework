package datadriventest;

import datadriven.ConnectToMongoDB;
import datadriven.InformationAndInsuranceHover;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class InformationAndInsuranceHoverTest extends InformationAndInsuranceHover {
    InformationAndInsuranceHover object;
    @BeforeMethod
    public void init(){
        object = PageFactory.initElements(driver, InformationAndInsuranceHover.class);
    }
    @Test
    public void testMenuItems()  {
        //setUpBrowserStack();
        List<String> spanText = ConnectToMongoDB.readFromMongoDB("infoMenu");
        List<WebElement> element = retInfoMenu();
        for(int index=0; index<element.size();index++) {
            Assert.assertEquals(element.get(index).getText(),spanText.get(index));
        }
    }
}