package screenshottests;

import base.CommonAPI;
import org.testng.annotations.Test;

public class ScreenShotTest extends CommonAPI {
    String screenShot1 = "ScreenShot";
    @Test
    public void testCaptureScreenShot(){
        captureScreenshot(driver, screenShot1);
    }

}
