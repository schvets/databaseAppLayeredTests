package Pages.UserTablePage;

import Pages.UserTablePage.uimaps.UserTablePageUIMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class UserTablePage {
    private UserTablePageUIMap controls;

    public UserTablePage() {
        controls = new UserTablePageUIMap();
    }

    public List<UserTablePageUIMap.UserTableRow> getTeamList() {
        return controls.getUserList();
    }

    public boolean isUserExistOnPage(Us team) {
        List<TeamListUIMap.TeamTableRow> listOfTeams = getTeamList();

        for (TeamListUIMap.TeamTableRow tableRow: listOfTeams) {
            if (tableRow.getNameTeam().getText().equals(team.getName())) {
                return true;
            }
        }

        return false;
    }

    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        for (int i = 1; i < controls.getUserList().size(); i++){
            users.add(i, controls.getUserList().get(i).);
        }
        return teams;
    }

/*    getUserList
            getUserCount*/

}
