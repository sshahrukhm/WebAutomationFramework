package homeOwnersPackage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PromptToCall extends CommonAPI {
    @FindBy(xpath = "//div[@id='home-get-a-quote']//h2")
    WebElement errorHeadline;
    @FindBy(xpath = "//*[@id=\"home-get-a-quote\"]/div[1]/div/div/p[1]")
    WebElement firstPara;

    public void navigateTo(){
        driver.navigate().to("https://propertysales.geico.com/Error/PromptToCall");
    }
    public void getErrorHeadline(){
        navigateTo();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home-get-a-quote")));
        // System.out.println(errorHeadline.getText());
        System.out.println(firstPara.getText());
    }
    public String actualErrorHead(){
        return "";
    }
}
