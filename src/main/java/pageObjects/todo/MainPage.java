package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//*[@data-testid='more_menu']")
    private WebElement btn_3dots;

    @FindBy(how = How.XPATH, using = "//*[text()='Add task']")
    private WebElement btn_create;

    @FindBy(how = How.XPATH, using = "//div[@class='markdown_content task_content']")
    private List<WebElement> list_tasks;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    private WebElement btn_addTask;

    @FindBy(how = How.XPATH, using = "//*[text()='Cancel']")
    private WebElement btn_cancel;

    @FindBy(how = How.XPATH, using = "//*[local-name()='svg']//*[name()='path' and @class='logo_bg']")
    private WebElement txt_logo;

    @FindBy(how = How.XPATH, using = "//*[text()='Delete task']")
    private WebElement btn_deleteTask;

    @FindBy(how = How.XPATH, using = "//*[text()='Delete']")
    private WebElement btn_delete;

    @FindBy(how = How.XPATH, using = "//input[@id='id-7m77ke']")
    private WebElement txt_search;

    @FindBy(how = How.XPATH, using = "//*[local-name()='div']//*[name()='div' and @id='quick_find']")
    private WebElement lnk_topBar;

    public WebElement getBtn_create(){
        return btn_create;
    }
    public List<WebElement> getList_tasks(){return list_tasks;}
    public WebElement getBtn_addTask(){
        return btn_addTask;
    }
    public WebElement getBtn_cancel(){
        return btn_cancel;
    }
    public WebElement getBtn_3dots(){
        return btn_3dots;
    }
    public WebElement getTxt_logo(){
        return txt_logo;
    }
    public WebElement getBtn_deleteTask(){
        return btn_deleteTask;
    }
    public WebElement getBtn_delete(){
        return btn_delete;
    }
    public WebElement getTxt_search(){
        return txt_search;
    }
    public WebElement getLnk_topBar(){
        return lnk_topBar;
    }
}
