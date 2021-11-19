package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Multiple: 7 * 8")
    public static void calculateMultiple() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_seven());
        UIActions.click(calcMain.getBtn_multiply());
        UIActions.click(calcMain.getBtn_eight());
        UIActions.click(calcMain.getBtn_equals());
    }
}
