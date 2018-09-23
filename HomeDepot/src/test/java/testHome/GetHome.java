package testHome;

import base.Home;
import org.testng.annotations.Test;

public class GetHome extends Home {
   @Test
    public void search(){
        super.search();
    }
    /*@Test
    public void cart(){
        super.cart();
    }
    @Test
    public void ShopBy(){
        super.ShopBy();
    }
    /*Test
   public void addToCart(){
        super.addToCart();
    }*/
    @Test
    public void clickOnMachine(){
       super.clickOnMachine();
    }
   @Test
   public void myAccount(){
        super.myAccount();
   }

}
