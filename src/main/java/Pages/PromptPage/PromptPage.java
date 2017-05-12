package Pages.PromptPage;

import Pages.PromptPage.uimaps.PromptPageUIMap;
import tools.controls.contracts.Button;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class PromptPage {
    public PromptPageUIMap control;

    public PromptPage() {
        this.control = new PromptPageUIMap();
    }

    public Button getOkButton(){
        return control.getOkButton();
    }
    public Button getCancelButton(){
        return control.getCancelButton();
    }
}
