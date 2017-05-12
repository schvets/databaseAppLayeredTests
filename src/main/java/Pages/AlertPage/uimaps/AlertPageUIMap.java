package Pages.AlertPage.uimaps;

import org.openqa.selenium.By;
import tools.ContextVisible;
import tools.Control;
import tools.controls.*;
import tools.controls.contracts.Button;

/**
 * Created by Aleksandr on 12.05.2017.
 */

public class AlertPageUIMap {
    private Button okButton;

    public AlertPageUIMap() {
        this.okButton = new ButtonImpl(new Control(new ContextVisible(By.cssSelector("#alertOK > center > button"))));
    }

    public Button getOkButton() {
        return okButton;
    }
}