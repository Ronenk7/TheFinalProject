package pageObjects.mobileMortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmortizationTables extends CommonOps {

    private AppiumDriver mobileDriver;
    /*
    ###################################################################################
    Method name: AmortizationTables
    Method description: This method initialize the appium driver
    Method parameters : AppiumDriver
    ###################################################################################
     */
    public AmortizationTables(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);

    }

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement btn_back;

    @AndroidFindBy(id = "btn_toggle_months_years")
    private AndroidElement btn_termView;

    @AndroidFindBy(id = "btn_start_date")
    private AndroidElement btn_startDate;

    @AndroidFindBy(id = "monthlyTable")
    private List<AndroidElement> list_AmortizationTables;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][5]")
    private List<AndroidElement> list_balance;

    public AndroidElement getBtn_back(){return btn_back;}
    public AndroidElement getBtn_termView(){return btn_termView;}
    public AndroidElement getBtn_startDate(){return btn_startDate;}
    public List<AndroidElement>getList_AmortizationTables(){return list_AmortizationTables;}
    public List<AndroidElement>getList_balance(){return list_balance;}
}






