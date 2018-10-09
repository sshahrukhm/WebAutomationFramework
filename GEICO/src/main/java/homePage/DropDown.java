package homePage;

import base.CommonAPI;
import dataReader.ConnectToMongoDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends CommonAPI {
    @FindBy(id="homepage_manage_select")
    public static WebElement accessYourPolicyDropDown;

    public List<String> getAccessYourPolicyList(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Select dropDown = new Select(accessYourPolicyDropDown);
        List<WebElement> dropDownList = dropDown.getOptions();
        List<String> dropDownListText = new ArrayList<>();
        for(WebElement it:dropDownList) {
            dropDownListText.add(it.getText());
        }
        return dropDownListText;
    }
    public List<String> getPolicyDataFromDB(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return ConnectToMongoDB.readFromMongoDB("dropDown","dropDownList");
    }
    public void compareDropDownData(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> expectedData = getAccessYourPolicyList();
        List<String> actualData = getPolicyDataFromDB();
        for(int i=0;i<actualData.size();i++){
            Assert.assertEquals(actualData.get(i),expectedData.get(i));
        }
    }
}