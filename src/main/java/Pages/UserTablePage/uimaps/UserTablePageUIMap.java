package Pages.UserTablePage.uimaps;

import Pages.contracts.Remapable;
import org.openqa.selenium.By;
import tools.ContextVisible;
import tools.Control;
import tools.ControlListWrapper;
import tools.controls.CheckboxImpl;
import tools.controls.LabelImpl;
import tools.controls.WebElementsList;
import tools.controls.contracts.Checkbox;
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

    public Checkbox getCheckbox() {
        return new CheckboxImpl(new Control(new ContextVisible(By.id("VIP"))));
    }

    public final List<UserTableRow> getUserList() {
        userList = new ArrayList<>();
        List<Label> firstNameLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.cssSelector("td:nth-child(2)")))).asLabels();
        List<Label> LastNameLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.cssSelector("td:nth-child(3)")))).asLabels();
        List<Label> GenderLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.cssSelector("td:nth-child(4)")))).asLabels();
        List<Label> CategoryLabel = new WebElementsList(new ControlListWrapper(new ContextVisible
                (By.cssSelector("td:nth-child(5)")))).asLabels();


        for (int i = 0; i < firstNameLabel.size(); i++) {
            System.out.println(i);
            System.out.println(firstNameLabel.get(i).getText());
            System.out.println(LastNameLabel.get(i).getText());
            System.out.println(GenderLabel.get(i).getText());
            System.out.println(CategoryLabel.get(i).getText());
            userList.add(new UserTableRow(firstNameLabel.get(i),
                    LastNameLabel.get(i),
                    GenderLabel.get(i),
                    CategoryLabel.get(i)));
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
        private Checkbox checkbox;
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

        public final Checkbox getUserCheckbox() {
            return checkbox;
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


