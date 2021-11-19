package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.mobileMortgage.AmortizationTables;

public class MangePages extends Base{
    /*
    ###################################################################################
    Method name: initMortgage
    Method description: This method initialize the elements
    ###################################################################################
     */
    public static void initMortgage() {
        mortgageMain = PageFactory.initElements(driver, pageObjects.mortgageORG.MainPage.class);
        mortgageGraph = PageFactory.initElements(driver, pageObjects.mortgageORG.GraphPage.class);
        mortgageMenu = PageFactory.initElements(driver, pageObjects.mortgageORG.MenuPage.class);
        mortgageRatesLinks = PageFactory.initElements(driver, pageObjects.mortgageORG.RatesLinksPage.class);
        mortgageSummary = PageFactory.initElements(driver, pageObjects.mortgageORG.MortgageRepaymentSummary.class);
        mortgageCurrentRates = PageFactory.initElements(driver, pageObjects.mortgageORG.CurrentMortgageRates.class);
    }
    /*
    ###################################################################################
    Method name: initMobileMortgage
    Method description: This method initialize the elements
    ###################################################################################
     */
    public static void initMobileMortgage() {
        mobileMortgageMain = new pageObjects.mobileMortgage.MainPage(mobileDriver);
        mobileAmortization = new AmortizationTables(mobileDriver);
    }
    /*
    ###################################################################################
    Method name: initTodo
    Method description: This method initialize the elements
    ###################################################################################
     */
    public static void initTodo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }
    /*
    ###################################################################################
    Method name: initCalculator
    Method description: This method initialize the elements
    ###################################################################################
     */
    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
