package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends CommonAPI {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    @FindBy(css = "#header-left-links > ul> li > a")
    public static WebElement insurance;
    @FindBy(css = "#header-middle-links > a")
    public static WebElement geicoLogo;
    @FindBy(css = "#header-right-links>ul>li>a>span.icon-geolocation")
    public static WebElement locationIcon;
    @FindBy(className = "login header-right-label open")
    public static WebElement login;
    @FindBy(css = "#header-right-links > ul > li:nth-child(3) > a > span")
    public static WebElement searchIcon;

    @FindBy(xpath = "//div[@data-side-panel='information']")
    public static WebElement infoDiv;
    @FindBy(xpath = "//div[@data-side-panel='insurance']")
    public static WebElement insuranceDiv;
    @FindBy(xpath = "//div[@data-side-panel='login']")
    public static WebElement loginDiv;
    @FindBy(xpath = "//div[@data-side-panel='location']")
    public static WebElement locationDiv;
    @FindBy(xpath = "//div[@data-side-panel='search']")
    public static WebElement searchDiv;

    public boolean clickOnInsurance() throws InterruptedException {
        insurance.click();
        Thread.sleep(2000);
        return insuranceDiv.isDisplayed();
    }

    public boolean clickOnInformation() throws InterruptedException {
        information.click();
        Thread.sleep(2000);
        return infoDiv.isDisplayed();
    }

    public String clickOnGeicoLogo() throws InterruptedException {
        geicoLogo.click();
        Thread.sleep(2000);
        String Url = driver.getCurrentUrl();
        return Url;
    }

    public boolean clickOnLocationIcon() throws InterruptedException {
        locationIcon.click();
        Thread.sleep(2000);
        return locationDiv.isDisplayed();
    }

    public boolean clickLogin() throws InterruptedException {
        locationIcon.click();
        Thread.sleep(2000);
        return loginDiv.isDisplayed();
    }

    public boolean clickOnSearchIcon() throws InterruptedException {
        searchIcon.click();
        Thread.sleep(2000);
        return searchDiv.isDisplayed();
    }
}
