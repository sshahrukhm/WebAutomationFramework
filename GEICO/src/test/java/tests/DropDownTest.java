package tests;

import datadriven.ConnectToMongoDB;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDown;

import java.util.List;

public class DropDownTest extends DropDown {
    DropDown object;
    @BeforeMethod
    public void init(){
        object = PageFactory.initElements(driver,DropDown.class);
    }
    @Test
    public void testDropDownList(){
        //List<String> actualText = getDropDownList();
        List<String> expectedText = ConnectToMongoDB.readFromMongoDB("dropDown");
        for(String st: expectedText)
            System.out.println(st);
    }
}