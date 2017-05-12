package Pages.AlertPage;

import Pages.AlertPage.uimaps.AlertPageUIMap;
import tools.controls.contracts.Button;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class AlertPage {
    public AlertPageUIMap control;

    public AlertPage() {
        this.control = new AlertPageUIMap();
    }

    public Button getOkButton(){
        return control.getOkButton();
    }
}
