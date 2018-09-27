package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

public class ReusableAPI { //Remember this class is not reading from that TestRunner.xml.

    public WebDriver driver = null;

    @Parameters({"os", "url"})
    @BeforeMethod
    public void setDriver(String os, String url) {
        setDriverForOS(os);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//       driver.manage().window().fullscreen();
        driver.navigate().to(url);
    }

    public void setDriverForOS(String os) {
        if (os.equalsIgnoreCase("Windows")) {
            System.setProperty("webdriver.chrome.driver", "..\\Generic\\DriversForBrowser\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (os.equalsIgnoreCase("Mac")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/DriversForBrowser/chromedriver");
            driver = new ChromeDriver();
        }
    }

/*
    @AfterMethod(alwaysRun = true)
    public void closeTest(){
        driver.quit();
    }*/

    //ExtentReport
    public static ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//            System.out.println();
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("..\\Airbnb\\screenshots\\ScreenShot.png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    //helper method
    public void hoverOver() throws InterruptedException {
        driver.findElement(By.id("NAV_ABOUT_US")).click();
        Thread.sleep(2000);
        WebElement e = driver.findElement(By.linkText("Who we are"));
        Actions ac = new Actions(driver);
        ac.moveToElement(e).build().perform();

    }

    //drag drop method
    public void DragDrop1(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

}
