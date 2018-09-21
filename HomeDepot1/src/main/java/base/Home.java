package base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

public class Home extends CommonAPI {
    ////input[@id='headerSearch']
    @FindBy(how = How.ID, using = "//input[@id='headerSearch']")
    public static WebElement searchbox;

    @FindBy(how = How.ID, using = "//div[@id='container']//div[@class='Header3']//ul[@class='ShoppingLinks']//a[@href='//www.homedepot.com/c/site_map']")
    public static WebElement allDepartments;

    @FindBy(how = How.ID, using = "//div[@id='container']//div[@class='Header3']//ul[@class='ShoppingLinks']//a[@href='//www.homedepot.com/c/shop_by_room']")
    public static WebElement shopByRoom;

    @FindBy(how = How.CSS, using = "#.ShoppingLinks [data-id='diyProjectsIdeas']")
    public static WebElement diyProjectandIdeal;

    @FindBy(how = How, using = "#.ShoppingLinks [data-id='homeServices']")
    public static WebElement homeService;

    @FindBy(how = How.CSS, using = "#.ShoppingLinks__link--closing']")
    public static WebElement specialsAndOffers;

    @FindBy(how = How.CSS, using = "#.ShoppingLinks [href='\\/\\/www\\.homedepot\\.com\\/c\\/localad']")
    public static WebElement localAd;

    @FindBy(how = How.CSS, using = "#headerMyAccount .SimpleFlyout__link--bold")
    public static WebElement myAccount;

    @FindBy(how = How.CSS, using = "#.MyCart__label")
    public static WebElement cart;


}