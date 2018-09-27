package datadriven;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InformationAndInsuranceHover extends CommonAPI {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul")
    public static WebElement informationDiv;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul/li/a/span[2]")
    public static WebElement infoMenuElements;
    public static String informationDivPath = "//div[@data-side-panel='information']/ul";
    public static String infoMenuElementsPath = "//div[@data-side-panel='information']/ul/li/a/span[2]";


    public List<WebElement> retMenuList(String parentXpath, String childXpath){
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath(parentXpath),By.xpath(childXpath)));
        WebElement divUL = driver.findElement(By.xpath(parentXpath));
        List<WebElement> unorderedList = divUL.findElements(By.xpath(childXpath));
        return unorderedList;
    }
    public List<WebElement> retInfoMenu(){
        information.click();
        List<WebElement> li = retMenuList(informationDivPath,infoMenuElementsPath);
        return  li;
    }
}