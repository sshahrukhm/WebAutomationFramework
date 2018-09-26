package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class CommonAPI {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\MyFiles\\Develop\\AutomationFramework\\Framework\\Generic\\browser-driver\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        //driver.manage().window().maximize();
        Thread.sleep(4000);
    }
    @AfterMethod
    public void end() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}