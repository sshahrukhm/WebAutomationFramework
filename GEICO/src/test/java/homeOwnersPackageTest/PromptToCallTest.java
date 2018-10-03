package homeOwnersPackageTest;

import homeOwnersPackage.PromptToCall;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PromptToCallTest extends PromptToCall {
    PromptToCall objePTC;
    @BeforeMethod
    public void init(){
        objePTC = PageFactory.initElements(driver,PromptToCall.class);
    }
    @Test
    public void testNavigation(){
       getErrorHeadline();
    }
}