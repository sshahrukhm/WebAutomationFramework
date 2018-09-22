package search;

import org.testng.annotations.Test;
import base.HomePage;

import java.sql.Driver;

public class HomePageTest extends HomePage {

    // @Test
//    public void testSignIn()throws InterruptedException{
//        driver.get("http://bestbuy.com");
//        methods.MainBestBuy.closePopUp();
//        methods.MainBestBuy.signInButton();
//        methods.MainBestBuy.signIn();
//    }
    @Test
    public void Account() {
        super.Account();
    }
    @Test
    public void ShoppingHistory() {
        super.ShoppingHistory();
    }
    @Test
    public void OrderStatus() {
        super.OrderStatus();
    }
    @Test
    public void SavedItems() {
        super.SavedItems();
    }
    @Test
    public void search() {
        super.search();
    }
}
