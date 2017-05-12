/**
 * Author S.Tsiganovskiy
 */
package tools.controls;

import tools.ContextVisible;
import tools.Control;
import tools.controls.contracts.Link;
import org.openqa.selenium.By;

/**
 * implementation of the Checkbox control for the web API.
 */
public class LinkImpl implements Link {
    /**
     * control wrapped as link.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrapAsLink - control to wrap as link.
     */
    public LinkImpl(final Control controlToWrapAsLink) {
        control = controlToWrapAsLink;
    }

    /**
     * gets the Link which is found by by via ContextVisible and
     * wrapped with Control.
     *
     * @param by - element to element from the page.
     * @return the Link which is found by by via ContextVisible
     * and wrapped with Control.
     */
    public Link get(final By by) {
        return new LinkImpl(new Control(new ContextVisible(by)));
    }

    @Override
    public final String getHref() {
        return control.getAttribute("href");
    }

    @Override
    public String getID() {
        return control.getAttribute("id");
    }

    @Override
    public boolean isVisible() {
        return control.isDisplayed();
    }

    @Override
    public final void click() {
        control.click();
    }

    @Override
    public final String getText() {
        return control.getText();
    }
}
