package base;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reporting.ExtentManager;

public class CommonAPI {
    public static WebDriver driver = null;
    public static Actions builder = null;
    public static WebDriverWait wait = null ;

    //ExtentReport
    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\MyFiles\\Develop\\AutomationFramework\\Framework\\Generic\\browser-driver\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.geico.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void end() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}