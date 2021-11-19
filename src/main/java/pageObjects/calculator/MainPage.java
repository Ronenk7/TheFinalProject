package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.NAME, using = "Seven")
    private WebElement btn_seven;

    @FindBy(how = How.NAME, using = "Eight")
    private WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Equals")
    private WebElement btn_equals;

    @FindBy(how = How.NAME, using = "Multiply by")
    private WebElement btn_multiply;

    @FindBy(how = How.NAME, using = "Clear")
    private WebElement btn_clear;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    private WebElement txt_result;


    public WebElement getBtn_seven(){return btn_seven;}
    public WebElement getBtn_eight(){return btn_eight;}
    public WebElement getBtn_equals(){return btn_equals;}
    public WebElement getBtn_multiply(){return btn_multiply;}
    public WebElement getBtn_clear(){return btn_clear;}
    public WebElement getTxt_result(){return txt_result;}
}
