package homePageTest;

import dataReader.ConnectToMySQL;
import homePage.Feedback;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends Feedback {
    ConnectToMySQL connect = new ConnectToMySQL();
    Feedback objFeedback;
    @BeforeMethod
    public void init(){
        objFeedback = PageFactory.initElements(driver,Feedback.class);
    }
    @AfterMethod
    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
    @Test
    public void testVeryDissatisfiedHeaderMessage(){
        Assert.assertEquals(getActualThankYouHeader(),getThankYouForFeedbackMessageHeader(veryDissatisfiedIcon));
    }
    @Test
    public void testVeryDissatisfiedBodyMessage(){
        Assert.assertEquals(getActualThankYouBody(),getThankYouForFeedbackMessageBody(veryDissatisfiedIcon));
    }
    @Test
    public void testDissatisfiedHeaderMessage(){
        Assert.assertEquals(getActualThankYouHeader(),getThankYouForFeedbackMessageHeader(dissatisfiedIcon));
    }
    @Test
    public void testDissatisfiedBodyMessage(){
        Assert.assertEquals(getActualThankYouBody(),getThankYouForFeedbackMessageBody(dissatisfiedIcon));
    }
    @Test
    public void testSomewhatSatisfiedHeaderMessage(){
        Assert.assertEquals(getActualThankYouHeader(),getThankYouForFeedbackMessageHeader(somewhatSatisfiedIcon));
    }
    @Test
    public void testSomewhatSatisfiedBodyMessage(){
        Assert.assertEquals(getActualThankYouBody(),getThankYouForFeedbackMessageBody(somewhatSatisfiedIcon));
    }
    @Test
    public void testSatisfiedHeaderMessage(){
        Assert.assertEquals(getActualThankYouHeader(),getThankYouForFeedbackMessageHeader(satisfiedIcon));
    }
    @Test
    public void testSatisfiedBodyMessage(){
        Assert.assertEquals(getActualThankYouBody(),getThankYouForFeedbackMessageBody(satisfiedIcon));
    }
    @Test
    public void testVerySatisfiedHeaderMessage(){
        Assert.assertEquals(getActualThankYouHeader(),getThankYouForFeedbackMessageHeader(verySatisfiedIcon));
    }
    @Test
    public void testVerySatisfiedBodyMessage(){
        Assert.assertEquals(getActualThankYouBody(),getThankYouForFeedbackMessageBody(verySatisfiedIcon));
    }
}