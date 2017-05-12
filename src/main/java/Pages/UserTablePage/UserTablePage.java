package Pages.UserTablePage;

import Pages.UserTablePage.uimaps.UserTablePageUIMap;
import entities.User;

import java.util.List;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class UserTablePage {
    private UserTablePageUIMap controls;

    public UserTablePage() {
        controls = new UserTablePageUIMap();
    }

    public List<UserTablePageUIMap.UserTableRow> getUserList() {
        return controls.getUserList();
    }

    public boolean isUserExistOnPage(User user) {
        List<UserTablePageUIMap.UserTableRow> listOfUsers = getUserList();

        for (UserTablePageUIMap.UserTableRow tableRow: listOfUsers) {
            if (tableRow.getfirstNameLabel().getText().equals(user.getUserFirstName()) &&
                    tableRow.getlastNameLabel().getText().equals(user.getUserLastName()) &&
                    tableRow.getCategoryLabel().getText().equals(user.getUserCategory()) &&
                    tableRow.getGenderLabel().getText().equals(user.getUserSex())) {
                return true;
            }
        }
        return false;
    }

    public void clickUserCheckbox(User user) {
        List<UserTablePageUIMap.UserTableRow> listOfUsers = getUserList();

        for (UserTablePageUIMap.UserTableRow tableRow: listOfUsers) {
            if (tableRow.getfirstNameLabel().getText().equals(user.getUserFirstName()) &&
                    tableRow.getlastNameLabel().getText().equals(user.getUserLastName()) &&
                    tableRow.getCategoryLabel().getText().equals(user.getUserCategory()) &&
                    tableRow.getGenderLabel().getText().equals(user.getUserSex())) {
                tableRow.getUserCheckbox().check();
            }
        }

    }

}
