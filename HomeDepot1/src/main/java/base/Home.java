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
    public static WebElement ShopByRoom;
}