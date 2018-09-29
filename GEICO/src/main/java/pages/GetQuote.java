package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GetQuote extends CommonAPI {
    @FindBy(xpath = "//div[@class='card-selections-card']//label")
    public static WebElement firstQuote;
    @FindBy(xpath = "//div[@class='button-bar']//button[@class='btn btn--primary btn--full-mobile']")
    public static WebElement getQuoteButton;
    @FindBy(css = ".skip-collect-intent.link--primary")
    public static WebElement skipButton;

    public void navigate() {
        driver.navigate().to("https://auto-buy.geico.com/nb#/sale/customerinformation/gskmsi");
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void getQuote() {
        navigate();
        waitToBeVisible(firstQuote);
        firstQuote.click();
        waitToBeVisible(getQuoteButton);
        getQuoteButton.click();
    }

    public void clickSkip() {
        navigate();
        waitToBeVisible(skipButton);
        skipButton.click();
    }
}