package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This test add a new task and verifies it in the list of tasks")
    public void test01_addAndVerifyNewTask() {

        ElectronFlows.addNewTask("  Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }

    @Test(description = "Test02 - Verify Task Deletion")
    @Description("This test verifies the deletion of a task")
    public void test02_addAndVerifyNewTask() {

        ElectronFlows.deleteLastUser();
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 0);
    }
}
