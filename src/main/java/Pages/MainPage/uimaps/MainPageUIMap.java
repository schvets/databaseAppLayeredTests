package Pages.MainPage.uimaps;

import org.openqa.selenium.By;
import tools.ContextVisible;
import tools.Control;
import tools.ControlListWrapper;
import tools.Select;
import tools.controls.*;
import tools.controls.contracts.*;

import java.util.List;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class MainPageUIMap {
    public Button getConnectButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("connect"))));
    }

    public final TextInput getFirstNameTextInput() {
        return new TextInputImpl(new Control(new ContextVisible(By.id("FirstName"))));
    }

    public final TextInput getLastNameTextInput() {
        return new TextInputImpl(new Control(new ContextVisible(By.id("LastName"))));
    }

    public final Checkbox getFemaleRadioButton() {
        return new CheckboxImpl(new Control(new ContextVisible(By.xpath("//input[@value='female']"))));
    }

    public final Checkbox getMaleRadioButton() {
        return new CheckboxImpl(new Control(new ContextVisible(By.xpath("//input[@value='male']"))));
    }

    public final Button getAddButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("Add"))));
    }

    public Button getDeleteButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("Delete"))));
    }

    public Dropdown  getCategoryDropDown() {
        return new DropdownImpl(new Select(new ContextVisible(By.id("Category"))));
    }

    public List<Link> getGenderList() {
        return new WebElementsList(new ControlListWrapper(new ContextVisible(By.id("Gender")))).asLinks();
    }

    public Button getLoadButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("Load"))));
    }

    public Button getSaveButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("Save"))));
    }

    public Button getClearButton() {
        return new ButtonImpl(new Control(new ContextVisible(By.id("Clear"))));
    }

    public Label getConnectionLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.id("connection"))));
    }

    public Label getCountLabel() {
        return new LabelImpl(new Control(new ContextVisible(By.id("count"))));
    }
}


