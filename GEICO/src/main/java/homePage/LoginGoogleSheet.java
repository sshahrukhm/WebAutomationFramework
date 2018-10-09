package homePage;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reporting.TestLogger;

import java.io.IOException;
import java.util.List;

import static dataReader.GoogleSheetReader.getSheetsService;

public class LoginGoogleSheet extends LoginExcelSheet{
    LoginExcelSheet loginExcelSheetObject = PageFactory.initElements(driver, LoginExcelSheet.class);

    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }
    public void signInByInvalidIdPass() throws IOException, InterruptedException {
        String spreadsheetId ="1WLJxQ97DTKoz4QR5KlXinQaXx8pGGC8gB-CnfNyYM20";
        String range= "Sheet1!A2:C";
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        navigateToLoginPage();
        List<List<Object>> col2Value = getSpreadSheetRecords(spreadsheetId, range);
        for (List row : col2Value) {
            String expectedMessage = SendLoginInfo(row.get(0).toString(),row.get(1).toString());
            String actualMessage = row.get(2).toString();
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }
}
