package Pages.PromptPage.uimaps;

import org.openqa.selenium.By;
import tools.ContextVisible;
import tools.Control;
import tools.controls.ButtonImpl;
import tools.controls.contracts.Button;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class PromptPageUIMap {
    private Button okButton;
    private Button cancelButton;

    public PromptPageUIMap() {
        this.okButton = new ButtonImpl(new Control(new ContextVisible
                (By.cssSelector("#alertOKCancel > center > button:nth-child(3)"))));
        this.cancelButton = new ButtonImpl(new Control(new ContextVisible
                (By.cssSelector("#alertOKCancel > center > button:nth-child(4)"))));
    }
    public Button getOkButton() {
        return okButton;
    }
    public Button getCancelButton() {
        return cancelButton;
    }
}