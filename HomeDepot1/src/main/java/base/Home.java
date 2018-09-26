package base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.concurrent.TimeUnit;


public class Home extends CommonAPI {


    public void search() {
        driver.findElement(By.cssSelector("#headerSearch")).sendKeys("Washing Machine", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void cart() {
        driver.findElement(By.cssSelector(".MyCart__label"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void ShopBy() {
        driver.findElement(By.cssSelector(".ShoppingLinks [data-id='room']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void clickOnMachine() {
        driver.findElement(By.cssSelector("[class='js-pod js-pod-0 plp-pod plp-pod--default pod-item--0'] .stretchy")).click();

    }

    /* public void addToCart(){
         driver.findElement(By.cssSelector("#[class='js-pod js-pod-0 plp-pod plp-pod--default pod-item--0'] .bttn__content")).click();
     }*/
    public void clickOnWashingMachine() {
        driver.findElement(By.cssSelector("//div[@id='con1_home_rr']//div[@class='carousel__stage']/div[1]//a[@href='//www.homedepot.com/b/Appliances-Refrigerators/N-5yc1vZc3pi?MERCH=CON1-_-con1_home_rr-_-bd69431f-3ef7-46a3-b709-1f00a7f7e3ee-_-N']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void myAccount() {
        driver.findElement(By.cssSelector("#headerMyAccount .SimpleFlyout__link--bold")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        Select select = new Select(driver.findElement(By.xpath("//span[contains(text(),'Register')]")));
        select.selectByVisibleText("Register");
    }
}

   /* @FindBy(how = How.CSS, using = "#headerMyAccount .SimpleFlyout__link--bold")
    public static WebElement myAccount;

    @FindBy(how = How.CSS, using = "#.MyCart__label")
    public static WebElement cart;

    @FindBy(how = How.CSS, using = "#[href='\\/b\\/Holiday-Decorations-Halloween-Decorations\\/N-5yc1vZc2ve'] img")
    public static WebElement imgRegardingHallowin;

    @FindBy(how = How.CSS, using = "[href='https\\:\\/\\/www\\.redcross\\.org\\/donate\\/cm\\/homedepot-pub\\.html\\/'] img")
    public static WebElement donateNowTab;

    //#container [class='  col__6-12 col__6-12--xs col__6-12--sm col__6-12--md col__6-12--lg col__6-12--xl']:nth-of-type(3) img
    @FindBy(how = How.CSS, using = "#container [class='  col__6-12 col__6-12--xs col__6-12--sm col__6-12--md col__6-12--lg col__6-12--xl']:nth-of-type(3) img")
    public static WebElement supportingLocal;













