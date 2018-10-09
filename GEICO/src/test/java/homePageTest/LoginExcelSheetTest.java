package homePageTest;

import homePage.LoginExcelSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class LoginExcelSheetTest extends LoginExcelSheet {
    LoginExcelSheet loginExcelSheetObject;
    @BeforeMethod
    public void init(){
        loginExcelSheetObject = PageFactory.initElements(driver, LoginExcelSheet.class);
        navigateToLoginPage();
    }
    @Test(dataProvider = "supplyData")
    public void signInWithInvalidIDPassUsingExcel(String email, String passCode, String message) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(message,SendLoginInfo(email, passCode));
    }
}