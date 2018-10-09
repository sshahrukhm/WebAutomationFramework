package homePageTest;

import homePage.LoginGoogleSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;

public class LoginGoogleSheetTest extends LoginGoogleSheet {
    LoginGoogleSheet googleSheetsPage;
    @BeforeMethod
    public void initialization(){
        googleSheetsPage = PageFactory.initElements(driver, LoginGoogleSheet.class);
    }
    @Test
    public void testLogInByInvalidIdPassUsingGoolgleSheet() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        signInByInvalidIdPass();
    }
}
