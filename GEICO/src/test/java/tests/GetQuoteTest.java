package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GetQuote;

public class GetQuoteTest extends GetQuote {
    GetQuote object;
    @BeforeMethod
    public void init(){
        object = PageFactory.initElements(driver,GetQuote.class);
    }
    @Test
    public void testGetQuoteButton(){
        getQuote();
    }
    @Test
    public void testSkipButton(){
        clickSkip();
    }
}
