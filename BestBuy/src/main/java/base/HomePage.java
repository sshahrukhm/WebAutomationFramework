package base;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {

//    static WebDriverWait wait = new WebDriverWait(Driver, 15, 1000);
//
//    public static void closePopUp(){
//        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".email-submission-model .model-header button.close")));
//    }

    //    public void cancelPopUp(){
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().frame("modal-content").findElement(By.xpath("//span['aria-hidden='true']").className("close")).click();
//    }
    public void Account() {
        driver.findElement(By.cssSelector("#hf_accountMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void ShoppingHistory() {
        driver.findElement(By.cssSelector("#hf_historyMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void OrderStatus() {
        driver.findElement(By.cssSelector("#hf_orderStatusMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void SavedItems() {
        driver.findElement(By.cssSelector("#hf_listsMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void search() {
        driver.findElement(By.cssSelector("[placeholder='Search Best Buy']")).sendKeys("smart tv", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}