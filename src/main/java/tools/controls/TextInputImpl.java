package tools.controls;

import tools.ContextVisible;
import tools.Control;
import tools.controls.contracts.TextInput;
import org.openqa.selenium.By;

/**
 * implementation of the TextInput control for the web API.
 *
 * @author J.Bodnar on 11.02.2016.
 */
public class TextInputImpl implements TextInput {

    /**
     * control wrapped as TextInput.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrap - control to wrap as link.
     */
    public TextInputImpl(final Control controlToWrap) {
        this.control = controlToWrap;
    }

    /**
     * gets the TextInput which is found by by via ContextVisible
     * and wrapped with Control.
     *
     * @param by - element to element from the page.
     * @return the TextInput which is found by by via
     * ContextVisible and wrapped with Control.
     */
    private TextInput get(final By by) {
        return new TextInputImpl(new Control(new ContextVisible(by)));
    }

    @Override
    public final boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public final void clear() {
        control.clear();
    }

    @Override
    public final void type(final String text) {
        control.sendKeys(text);
    }

    @Override
    public final void submit() {
        control.submit();
    }

    @Override
    public final void click() {
        control.click();
    }

    @Override
    public final String getText() {
        return control.getValue();
    }
}

