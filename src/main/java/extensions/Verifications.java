package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Verifications extends CommonOps {

    @Step("Verify Text in Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Text in Text")
    public static void verifyText(double actual, double expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Text in Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Text in Texts (Soft-Assertion")
    public static void visibilityOfElements(List<List<Double>> lists) {
        for (int i = 1; i < lists.size()-1; i++) {
            softAssert.assertTrue(lists.get(i).get(0) > lists.get(i + 1).get(0));
            softAssert.assertFalse(lists.get(i).get(1) > lists.get(i + 1).get(1));
            softAssert.assertTrue(lists.get(i).get(2) > lists.get(i + 1).get(2));
        }
        softAssert.assertAll();
    }

      @Step("Verify Element Visually")
      public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image File: " + e);
            fail("Error Comparing Image File: " + e);
       }
   }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        assertEquals(actual, expected);
    }
}
