package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonAPI {

    public WebDriver driver;

    public static WebElement convertToString(String name) {

       return null;
    }

    /**
     * Using parameters to make it more customizable, User is able to
     * provide desired information about @params[platform, browser, url]
     * in their TestNG.xml file rather than hard coding it.
     * @param platform
     * @param browser
     * @param url
     */

    @BeforeClass
    @Parameters({"platform", "browser", "url"})
    public void setUp(String platform, String browser, String url) {
        localDriver(platform, browser);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public void localDriver(String platform, String browser) {
        if (platform.contains("Mac")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver");
                driver = new FirefoxDriver();
            }
        } else if (platform.contains("Win")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
    }

    /**
     * AfterMethod captures Screenshots with the help of 'captureScreenshot' method
     * Which get saved under screenshots directory under Users individual modules
     * and to make the names stand out from each other, Current Date is added
     * so User can distinguish the screenshots.
     * @param result
     */

    @AfterMethod
    public void captureScreenshotsIfFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to capture screenshot and provide current date
    private void captureScreenshot(String name) {
        DateFormat dateFormat = new SimpleDateFormat("(HH.mm.yyyy-HH;mma)");
        Date date = new Date();

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = null;

        if (System.getProperty("os.name").contains("Mac")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "/screenshots/" + name + " " + dateFormat.format(date) + ".png");
        } else if (System.getProperty("os.name").contains("Win")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "\\screenshots\\" + name + " " + dateFormat.format(date) + ".png");
        }
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {

        }
    }
}