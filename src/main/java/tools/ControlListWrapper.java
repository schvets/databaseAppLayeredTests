package tools;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to wrap a list of WebElement's with list of Control's
 * or optionally list of Select's.
 *
 * @author Danil Zhyliaiev
 */
public class ControlListWrapper {
    private final Context contextVisible;

    public ControlListWrapper(Context contextVisible) {
        this.contextVisible = contextVisible;
    }

    /**
     * @return the List of wrapped Controls.
     */
    public final List<Control> get() {
       return contextVisible.elements()
               .stream()
               .map(Control::new)
               .collect(Collectors.toList());
    }

    /**
     * gets the Select tags form the <code>webElements</code> into an ArrayList.
     *
     * @return List&#60SelectWrapper>
     */
    public final List<Select> getSelects() {
        return contextVisible
                .elements()
                .stream()
                .map(Select::new)
                .collect(Collectors.toList());
    }
}
