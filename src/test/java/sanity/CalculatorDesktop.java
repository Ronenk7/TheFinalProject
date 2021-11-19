package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test 01 - Verify Calculate Multiple")
    @Description("This test verify calculate multiple")
    public void test01_verifyCalculateMultiple() {

        DesktopFlows.calculateMultiple();
        Verifications.verifyTextInElement(calcMain.getTxt_result(), "Display is 56");
    }
}
