package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to the List")
    public static void addNewTask(String taskName) {
        wait.until(ExpectedConditions.visibilityOf(todoMain.getTxt_logo()));
        wait.until(ExpectedConditions.invisibilityOf(todoMain.getTxt_logo()));
        UIActions.updateText(todoMain.getBtn_create(), taskName);
        UIActions.click(todoMain.getBtn_addTask());
        UIActions.click(todoMain.getBtn_cancel());

    }

    @Step("Count and Return Number of Tasks in List")
    public static int getNumberOfTasks() {
        return todoMain.getList_tasks().size();
    }

    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        if(todoMain.getList_tasks().size() > 0) {
            UIActions.mouseHover(todoMain.getList_tasks().get(todoMain.getList_tasks().size() - 1),
                    todoMain.getBtn_3dots());
            UIActions.click(todoMain.getBtn_deleteTask());
            UIActions.click(todoMain.getBtn_delete());
        }
        else
            System.out.println("There are no task left");
    }
}
