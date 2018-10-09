package autoInsurancePackage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class GetQuote extends CommonAPI {
    @FindBy(xpath = "//div[@class='card-selections-card']//label")
    public static WebElement firstQuote;
    @FindBy(xpath = "//div[@class='button-bar']//button[@class='btn btn--primary btn--full-mobile']")
    public static WebElement getQuoteButton;
    @FindBy(css = ".skip-collect-intent.link--primary")
    public static WebElement skipButton;
    public void navigate() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.navigate().to("https://auto-buy.geico.com/nb#/sale/customerinformation/gskmsi");
    }
    public void getQuote(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        navigate();
        waitToBeVisible(firstQuote);
        firstQuote.click();
        waitToBeVisible(getQuoteButton);
        getQuoteButton.click();
    }
    public void clickSkip(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        navigate();
        waitToBeVisible(skipButton);
        skipButton.click();
    }
}