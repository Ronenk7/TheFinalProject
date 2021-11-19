package sanity;

import extensions.MobileVerifications;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test 01 - Verify Mortgage")
    @Description("This test fill in mortgage fields and calculate repayment")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("300000", "3.5", "25");
        Verifications.verifyText(mobileMortgageMain.getTxt_payment().getText(), "1,501.87");
    }

    @Test(description = "Test 02 - Verify Mortgage Balance Goes Down")
    @Description("This test verify that the balance goes down each year")
    public void test02_verifyBalance() {
        MobileFlows.calculateMortgage("1000000", "4", "15");
        MobileFlows.AmortizationTables();
        MobileVerifications.balanceDropping();

    }
}
