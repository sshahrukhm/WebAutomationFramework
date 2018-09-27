package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InsuranceProducts;
import reporting.TestLogger;


public class InsuranceProductsTest extends InsuranceProducts {

    InsuranceProducts insuranceProducts;

    @BeforeMethod
    public void init() {
        insuranceProducts = PageFactory.initElements(driver, InsuranceProducts.class);
    }

    @Test
    public void testHomeOwnerInsuranceIconClick() {
        clickOnHomeOwnersInsuranceIcon();
    }

    @Test
    public void testRentersInsuranceIconClick() {
        clickOnRentersInsuranceIcon();
    }

    @Test
    public void testMotorCycleInsuranceIconClick() {
        clickOnMotorCycleInsurance();
        TestLogger.log("ist");
    }

    @Test
    public void testCondoInsuranceIconClick() {
        clickOnCondoInsurance();
    }

    @Test
    public void testBoatInsuranceIconClick() {
        clickOnBoatInsurance();
    }

    @Test
    public void testUmbrellaInsuranceIconClick() {
        clickOnUmbrellaInsurance();
    }

    @Test
    public void testRVInsuranceIconClick() {
        clickOnRVInsurance();
    }

    @Test
    public void testCollectorAutoInsuranceIconClick() {
        clickOnCollectorAutoIcon();
    }

    @Test
    public void testMobileHomeInsuranceIconClick() {
        clickOnMobileHomeIcon();
    }

    @Test
    public void testFloodInsuranceIconClick() {
        clickOnFloodIcon();
    }

    @Test
    public void testCommercialAutoInsuranceIconClick() {
        clickOnCommercialAutoIcon();
    }

    @Test
    public void testGeneralLiabilityInsuranceIconClick() {
        clickOnGeneralLiabilityIcon();
    }

    @Test
    public void testProfessionalLiabilityInsuranceIconClick() {
        clickOnProfessionalLiabilityIcon();
    }

    @Test
    public void testBusinessOwnersInsuranceIconClick() {
        clickOnBusinessOwnersIcon();
    }

}
