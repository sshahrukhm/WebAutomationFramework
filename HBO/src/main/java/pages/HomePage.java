package pages;


import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {



    public void clickOnMyAccountButton() {


        driver.findElement(By.cssSelector(".bands\\/MainNavigation--topBar .components\\/BasicButton--children")).click();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }


    public void search() {

        driver.findElement(By.id("headerSearch")).sendKeys("outlet", Keys.ENTER);

    }


}