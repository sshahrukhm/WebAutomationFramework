package navigationBar;

import base.CommonAPI;
import dataReader.ConnectToMongoDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import reporting.TestLogger;
import java.util.List;

public class InformationAndInsuranceHover extends CommonAPI {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    public static String informationDivPath = "//div[@data-side-panel='information']/ul";
    public static String infoMenuElementsPath = "//div[@data-side-panel='information']/ul/li/a/span[2]";
    @FindBy(xpath = "//a[@data-side-panel-trigger='insurance']")
    public static WebElement insurance;
    public static String insuranceDivPath = "//div[@data-side-panel='insurance']/ul";
    public static String insuranceMenuElementsPath = "//div[@data-side-panel='insurance']/ul/li/a/span[2]";


    public List<WebElement> getMenuList(String parentXpath, String childXpath){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        waitToBeVisible(parentXpath);
        List<WebElement> unorderedList = driver.findElements(By.xpath(childXpath));
        return unorderedList;
    }
    public List<WebElement> getInformationMenuList(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        information.click();
        List<WebElement> li = getMenuList(informationDivPath,infoMenuElementsPath);
        return  li;
    }
    public void compareInformationMenu(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> actualText = ConnectToMongoDB.readFromMongoDB("navigationBar","information");
        List<WebElement> expectedText = getInformationMenuList();
        for(int i=0;i<6;i++){
            Assert.assertEquals(actualText.get(i),expectedText.get(i).getText());
        }
    }

    public List<WebElement> getInsuranceMenuList(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        insurance.click();
        List<WebElement> li = getMenuList(insuranceDivPath,insuranceMenuElementsPath);
        return  li;
    }
    public void compareInsuranceMenu(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> actualText = ConnectToMongoDB.readFromMongoDB("navigationBar","insurance");
        List<WebElement> expectedText = getInsuranceMenuList();
        int index=0;
        for(int i=6;i<10;i++){
            System.out.println(actualText.get(i));
            Assert.assertEquals(actualText.get(i),expectedText.get(index).getText());
            index++;
        }
    }
}
