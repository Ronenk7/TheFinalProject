package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String propertyValue, String Interest, String term) {
        MobileActions.updateText(mobileMortgageMain.getTxt_loanAmount(), propertyValue);
        MobileActions.updateText(mobileMortgageMain.getTxt_interest(), Interest);
        MobileActions.updateText(mobileMortgageMain.getTxt_term(), term);
    }

    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void AmortizationTables() {
        MobileActions.click(mobileMortgageMain.getBtn_Amortization());
        MobileActions.click(mobileAmortization.getBtn_termView());
    }
}
