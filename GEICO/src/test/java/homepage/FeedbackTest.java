package homepage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends Feedback{
    Feedback objFeedback;
    @BeforeMethod
    public void init(){
        objFeedback = PageFactory.initElements(driver,Feedback.class);
    }
    @Test
    public void testFeedback(){
        giveFeedback();
    }
}
