package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver = null;

    @BeforeMethod
    @Parameters({"platform", "browser", "url"})
    public void setUp(String platform, String browser, String url) throws InterruptedException {
        localDriver(platform, browser);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public void localDriver(String platform, String browser) throws InterruptedException {
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


    @AfterMethod
    public void cleanUp(){
        driver.close();
    }


}
