package tools.controls;


import tools.Control;
import tools.ControlListWrapper;
import tools.Select;
import tools.controls.contracts.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to handle and represent list of Control's as list of
 * needed Controls.
 *
 * @author Danil Zhyliaiev
 */
public final class WebElementsList {

    /**
     * the List of wrapped Controls.
     */
    private List<Control> controls;

    /**
     * The list of Controls.
     */
    private ControlListWrapper controlListWrapper;

    /**
     * Constructor.
     * <code>fields</code> initialization.
     *
     * @param aControlListWrapper list to be manipulated with.
     */
    public WebElementsList(final ControlListWrapper aControlListWrapper) {
        controlListWrapper = aControlListWrapper;
        controls = controlListWrapper.get();
    }

    /**
     * @return List*#60Button> got from the <code>controls</code>
     */
    public List<Button> asButtons() {
        List<Button> buttons = new ArrayList<>();

        for (Control control : controls) {
            buttons.add(new ButtonImpl(control));
        }

        return buttons;
    }

    /**
     * @return List*#60Checkbox> got from the <code>controls</code>
     */
    public List<Checkbox> asCheckboxes() {
        List<Checkbox> checkboxes = new ArrayList<>();

        for (Control control : controls) {
            checkboxes.add(new CheckboxImpl(control));
        }

        return checkboxes;
    }

    /**
     * @return List*#60Dropdown> got from the <code>controls</code>
     */
    public List<Dropdown> asDropdowns() {
        List<Dropdown> dropdowns = new ArrayList<>();

        for (Select control : controlListWrapper.getSelects()) {
            dropdowns.add(new DropdownImpl(control));
        }

        return dropdowns;
    }

    /**
     * @return List*#60Label> got from the <code>controls</code>
     */
    public List<Label> asLabels() {
        List<Label> labels = new ArrayList<>();

        for (Control control : controls) {
            labels.add(new LabelImpl(control));
        }

        return labels;
    }

    /**
     * @return List*#60Link> got from the <code>controls</code>
     */
    public List<Link> asLinks() {
        List<Link> links = new ArrayList<>();

        for (Control control : controls) {
            links.add(new LinkImpl(control));
        }

        return links;
    }

    /**
     * @return List*#60TextInput> got from the <code>controls</code>
     */
    public List<TextInput> asTextInputs() {
        List<TextInput> textInputs = new ArrayList<>();

        for (Control control : controls) {
            textInputs.add(new TextInputImpl(control));
        }

        return textInputs;
    }

    /**
     * @return List*#60CustomElement> got from the <code>controls</code>
     */
    public List<CustomElement> asCustomElements() {
        List<CustomElement> textInputs = new ArrayList<>();

        for (Control control : controls) {
            textInputs.add(new CustomElementImpl(control));
        }

        return textInputs;
    }
}
