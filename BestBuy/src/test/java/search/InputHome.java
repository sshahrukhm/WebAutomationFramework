package search;

import org.testng.annotations.Test;
import base.CommonAPI;
import base.HomePage;


public class InputHome {
    @Test
    public void search(){
        typeOnInputBox("#gh-ac","ring");
    }

    private void typeOnInputBox(String s, String ring) {
    }
}
