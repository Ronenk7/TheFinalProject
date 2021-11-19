package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps  {

    @Test(description = "Test 01 - Add Team And Verify")
    @Description("This test add a team to grafana and verify it")
    public void test01_addTeamAndVerify(){
        ApiFlows.postTeam("RonenTeam", "Ronen@team.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "RonenTeam");
    }

    @Test(description = "Test 02 - Update Team And Verify")
    @Description("This test updates a team in grafana and verify it")
    public void test02_updateTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("RonenTeam", "Ronen@netanya.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].email"), "Ronen@netanya.com");
    }

    @Test(description = "Test 03 - Delete Team And Verify")
    @Description("This test delete a team in grafana and verify it")
    public void test03_deleteTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "0");
    }
}
