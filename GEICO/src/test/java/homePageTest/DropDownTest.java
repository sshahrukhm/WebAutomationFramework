package homePageTest;

import homePage.DropDown;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class DropDownTest extends DropDown {
    DropDown object;
    @BeforeMethod
    public void init(){
        object = PageFactory.initElements(driver,DropDown.class);
    }
    @Test
    public void testDropDownList() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        compareDropDownData();
    }
}