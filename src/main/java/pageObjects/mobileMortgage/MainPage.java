package pageObjects.mobileMortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MainPage  extends CommonOps {

    private AppiumDriver mobileDriver;
    /*
    ###################################################################################
    Method name: MainPage
    Method description: This method initialize the appium driver
    Method parameters : AppiumDriver
    ###################################################################################
     */
    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3,
                TimeUnit.SECONDS), this);
    }

    @AndroidFindBy (id = "loan_amount")
    private AndroidElement txt_loanAmount;

    @AndroidFindBy (id = "interest_rate")
    private AndroidElement txt_interest;

    @AndroidFindBy (id = "loan_term")
    private AndroidElement txt_term;

    @AndroidFindBy (id = "monthly_payment")
    private AndroidElement txt_payment;

    @AndroidFindBy (id = "loan_term_types_spinner")
    private AndroidElement drp_termType;

    @AndroidFindBy (id = "payment_types_spinner")
    private AndroidElement drp_paymentTermType;

    @AndroidFindBy (id = "total_interest_result_textview")
    private AndroidElement txt_totalInterest;

    @AndroidFindBy (id = "total_repayment_result_textview")
    private AndroidElement txt_totalRepayment;

    @AndroidFindBy (id = "btn_go_to_table")
    private AndroidElement btn_Amortization;

    @AndroidFindBy (id = "btn_go_to_chart")
    private AndroidElement btn_charts;

    public AndroidElement getTxt_loanAmount(){return txt_loanAmount;}
    public AndroidElement getTxt_interest(){return txt_interest;}
    public AndroidElement getTxt_term(){return txt_term;}
    public AndroidElement getTxt_payment(){return txt_payment;}
    public AndroidElement getDrp_termType(){return drp_termType;}
    public AndroidElement getDrp_paymentTermType(){return drp_paymentTermType;}
    public AndroidElement getTxt_totalInterest(){return txt_totalInterest;}
    public AndroidElement getTxt_totalRepayment(){return txt_totalRepayment;}
    public AndroidElement getBtn_Amortization(){return btn_Amortization;}
    public AndroidElement getBtn_charts(){return btn_charts;}
}
