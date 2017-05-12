package tools.controls;

import tools.ContextVisible;
import tools.Control;
import tools.controls.contracts.Button;
import org.openqa.selenium.By;

/**
 * Created by Sasha on 18.03.2017.
 */
public class ButtonImplementDec implements Button {

    private Button button;

    public ButtonImplementDec(By by) {
        this.button = new ButtonImpl(new Control(new ContextVisible(by)));
    }

    @Override
    public boolean isDisplayed() {
        return button.isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return button.isEnabled();
    }

    @Override
    public String getText() {
        return button.getText();
    }


    @Override
    public void click() {
        button.click();
    }
}
