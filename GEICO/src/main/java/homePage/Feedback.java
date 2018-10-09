package homePage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import reporting.TestLogger;

public class Feedback extends CommonAPI {
    @FindBy(name = "OnlineOpinion1")
    public static WebElement feedbackFrame;
    @FindBy(xpath = "//label[@for='overall_0']")
    public static WebElement veryDissatisfiedIcon;
    @FindBy(xpath = "//label[@for='overall_1']")
    public static WebElement dissatisfiedIcon;
    @FindBy(xpath = "//label[@for='overall_2']")
    public static WebElement somewhatSatisfiedIcon;
    @FindBy(xpath = "//label[@for='overall_3']")
    public static WebElement satisfiedIcon;
    @FindBy(xpath = "//label[@for='overall_4']")
    public static WebElement verySatisfiedIcon;
    @FindBy(xpath = "//div[@id='foot']/button")
    public static WebElement submitButton;
    @FindBy(id="thank-you-header")
    public static WebElement ThankYouHeader;
    @FindBy(xpath = "//p[@id=\"tyMessage\"]/p")
    public static WebElement ThankYouBody;

    public void switchToFrame(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.id("oo_tab")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(feedbackFrame));
    }
    public void selectSatisfactionIcon(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName())+" Satisfaction level: "+element.getText());
        element.click();
    }
    public void clickSubmit(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        submitButton.click();
    }
    public void giveFeedback(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        switchToFrame();
        selectSatisfactionIcon(element);
        clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tyMessage")));
    }
    public String getThankYouForFeedbackMessageHeader(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        giveFeedback(element);
        return ThankYouHeader.getText();
    }
    public String getThankYouForFeedbackMessageBody(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        giveFeedback(element);
        return ThankYouBody.getText();
    }
    public String getActualThankYouHeader(){
        return "Thanks for your feedback!";
    }
    public String getActualThankYouBody(){
        return "While we research each report we receive, we cannot guarantee that your comment will receive a response.";
    }
}