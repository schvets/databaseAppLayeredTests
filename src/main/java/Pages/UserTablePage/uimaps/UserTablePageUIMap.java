package Pages.UserTablePage.uimaps;

import Pages.contracts.Remapable;
import org.openqa.selenium.By;
import tools.ContextVisible;
import tools.Control;
import tools.ControlListWrapper;
import tools.controls.LabelImpl;
import tools.controls.WebElementsList;
import tools.controls.contracts.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class UserTablePageUIMap implements Remapable {
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label GenderLabel;
    private Label CategoryLabel;

    private List<UserTableRow> userList;


    public Label getFirstNameLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.cssSelector("#heading > td:nth-child(2)"))));
    }

    public Label getLastNameLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.cssSelector("#heading > td:nth-child(3)"))));
    }

    public Label getGenderLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.cssSelector("#heading > td:nth-child(4)"))));
    }

    public Label getCategoryLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.cssSelector("#heading > td:nth-child(5)"))));
    }

    public final List<UserTableRow> getUserList() {
        userList = new ArrayList<>();
        List<Label> firstNameLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.xpath("//table[@id='VIPs']/td:nth-child(2)")))).asLabels();
        List<Label> LastLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.xpath("//table[@id='VIPs']/td:nth-child(3)")))).asLabels();
        List<Label> GenderLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.xpath("//table[@id='VIPs']/td:nth-child(4)")))).asLabels();
        List<Label> CategoryLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.xpath("//table[@id='VIPs']/td:nth-child(5)")))).asLabels();

        for (int i = 1; i < firstNameLabel.size() - 1; i++) {
            userList.add(new UserTableRow(firstNameLabel.get(i),
                    LastLabel.get(i), GenderLabel.get(i), CategoryLabel.get(i)));
        }
        return userList;
    }

    public int getUserCount() {
        userList = new ArrayList<>();
        List<Label> rowLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.xpath("//table[@id='VIPs']/tbody/tr")))).asLabels();
        return rowLabel.size();
    }

    @Override
    public void remap() {
        firstNameLabel = null;
        lastNameLabel = null;
        GenderLabel = null;
        CategoryLabel = null;

    }

    public class UserTableRow {

        private Label firstNameLabel;
        private Label lastNameLabel;
        private Label GenderLabel;
        private Label CategoryLabel;

        public UserTableRow(Label firstName, Label lastName, Label Gender, Label Category) {
            this.firstNameLabel = firstName;
            this.lastNameLabel = lastName;
            this.GenderLabel = Gender;
            this.CategoryLabel = Category;
        }

        public final Label getfirstNameLabel() {
            return firstNameLabel;
        }

        public final Label getlastNameLabel() {
            return lastNameLabel;
        }

        public final Label getGenderLabel() {
            return GenderLabel;
        }

        public final Label getCategoryLabel() {
            return CategoryLabel;
        }
    }
}


