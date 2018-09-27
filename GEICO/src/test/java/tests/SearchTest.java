package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Search;

public class SearchTest extends Search {
    public String keys = "motorcycle";
    Search search;
    @BeforeMethod
    public void init(){
        search = PageFactory.initElements(driver,Search.class);
    }
    @Test
    public void testSearchWithoutButton(){
        searchWithENTER(keys);
    }
    @Test
    public void testSearchWithButton(){
        searchUsingButton(keys);
    }
}