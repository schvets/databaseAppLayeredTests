package tools.controls;


import tools.Control;
import tools.controls.contracts.Label;

/**
 * implementation of the Dropdown control for the web API.
 *
 * @author J.Bodnar on 11.02.2016.
 */
public class LabelImpl implements Label {

    /**
     * control to wrap as a label.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrap - control to wrap as a Label.
     */
    public LabelImpl(final Control controlToWrap) {
        control = controlToWrap;
    }

    @Override
    public final String getText() {
        return control.getText();
    }

    @Override
    public final boolean isDisplayed() {

            return control.isDisplayed();


    }
}
