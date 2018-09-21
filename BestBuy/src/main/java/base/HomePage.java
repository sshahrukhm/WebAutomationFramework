package base;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    @FindBy(how = How.CSS, using = "#gh-ac")
    public static WebElement searchInputWebElement;

    @FindBy(how = How.CSS, using = "#gh-btn")
    public static WebElement submitButtonWebElement;

    public WebElement getSearchInputWebElement() {
        TestLogger.log(getClass().getSimpleName() + ":" + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        return searchInputWebElement;
    }
    public WebElement getSubmitButtonWebElement() {
        TestLogger.log(getClass().getSimpleName() + ":" + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        return submitButtonWebElement;
    }
    public void serachFor(String value) {
        TestLogger.log(getClass().getSimpleName() + ":" + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        getSearchInputWebElement().sendKeys(value);
    }
    public void submitSearchButton() {
        TestLogger.log(getClass().getSimpleName() + ":" + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        getSubmitButtonWebElement().click();
    }
    public void clearInput() {
        TestLogger.log(getClass().getSimpleName() + ":" + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        getSearchInputWebElement().clear();
    }
    public List<String> getMenuData() {
        List<String> data = new ArrayList<String>();
        data.add("Note 8");
        data.add("Pen");
        data.add("Watch");
        return data;
    }
    public void searchItemsAndSubmitButton() throws IOException {
        //TestLogger.log(getClass().getSimpleName()+":" + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = getItemValue();
        for (int i = 0; i < list.size(); i++) {
            serachFor(list.get(i));
            submitSearchButton();
            clearInput();
        }
    }

    public WebElement getSearchInputField() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        return searchInputWebElement;
    }
    public void setSearchInputField(WebElement searchInputField) {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        this.searchInputWebElement = searchInputField;
    }
    public void searchItems() throws InterruptedException {
        List<String> itemList = getItemValue();
        for (String st : itemList) {
            getSearchInputField().sendKeys(st, Keys.ENTER);
            getSearchInputField().clear();
        }
    }
    public List<String> getItemValue() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("smart tv");
        itemsList.add("smartwatch");
        itemsList.add("smartphone");
        itemsList.add("laptop");
        itemsList.add("desktop computer");
        itemsList.add("headphone");
        itemsList.add("camera");
        itemsList.add("ps4games");
        itemsList.add("macAir");

        return itemsList;
    }
}
