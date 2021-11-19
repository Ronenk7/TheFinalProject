package extensions;

import io.qameta.allure.Step;

public class MobileVerifications extends Verifications {

    @Step("Verify Text goes down")
    public static void balanceDropping() {
        int cycleNumber = 0;
        if(mobileAmortization.getList_balance().size()>25)
            cycleNumber = 2;
        if(mobileAmortization.getList_balance().size()<=25)
            cycleNumber = 1;
        for(int j=0; j<cycleNumber; j++) {
            for (int i = 1; i < mobileAmortization.getList_balance().size() - 1; i++) {
                System.out.println(Double.parseDouble(mobileAmortization.getList_balance().get(i).getText().replaceAll("[^0-9.]", "")));
                softAssert.assertTrue(Double.parseDouble(mobileAmortization.getList_balance().get(i).getText().replaceAll("[^0-9.]", "")) >
                        Double.parseDouble(mobileAmortization.getList_balance().get(i + 1).getText().replaceAll("[^0-9.]", "")));
            }
            MobileActions.executeScript("seetest:client.swipe(\"Down\", 1000, 5000)");
        }
    }
}

