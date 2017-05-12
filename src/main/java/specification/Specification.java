package specification;

/**
 * @author Danil Zhyliaiev
 */


import specification.criteria.*;
import tools.controls.contracts.*;
import specification.criteria.CheckboxCriteria;

import java.util.List;

/**
 * Contains the <code>StringBuilder summaryDescription</code> which is to store
 * all the error messages which are generated during the test case running
 * and the mechanism to build the <code>summaryDescription</code>.
 */
public final class Specification {

    /**
     * if there NO error occurred.
     */
    private boolean summaryResult;
    /**
     * all the error messages which are generated during the test case running.
     */
    private StringBuilder summaryDescription;

    /**
     * Constructor.
     * primary initialization of the fields.
     */
    public Specification() {
        summaryResult = true;
        summaryDescription = new StringBuilder();
    }

    /**
     * Accessor.
     *
     * @return <code>summaryResult</code>.
     * true  if there NO  error occurred,
     * false if there any error occurred
     */
    public boolean getPassed() {
        return summaryResult;
    }

    /**
     * Accessor.
     *
     * @return <code>summaryDescription</code> as a String
     */
    public String getDescription() {
        return summaryDescription.toString();
    }

    /**
     * Changes the Specification object state.
     * Should be called after every test step.
     * <p>
     * adds the potentially occurred error
     * to the <code>summaryDescription</code>
     *  @param pass      true if it is not an error (test step result is valid).
     * @param errorText error message.*/
    public void add(final boolean pass, final String errorText) {
        summaryResult = summaryResult && pass;

        if (!pass) {
            summaryDescription.append(errorText).append(System.getProperty("line.separator"));
        }
    }

    /**
     * should be called at the end of the test case in order to validate
     * if there any error occurred during the test case running.
     * <p>
     * if there any error occurred during the running the test case, the
     * "?AssertationError?" will be thrown with the
     * <code>summaryDescription</code> as an errorMessage.
     */
    public Specification check() {
        if (!summaryResult) {
            throw new AssertionError(summaryDescription.toString());
        }
        return null;
    }

    /**
     * @param checkbox control to element Criteria for.
     * @return CheckboxCriteria.
     */
    public CheckboxCriteria forThe(final Checkbox checkbox) {
        return new CheckboxCriteria(checkbox, this);
    }

    /**
     * @param dropdown control to element Criteria for.
     * @return DropdownCriteria.
     */
    public DropdownCriteria forThe(final Dropdown dropdown) {
        return new DropdownCriteria(dropdown, this);
    }

    /**
     * @param label control to element Criteria for.
     * @return LabelCriteria.
     */
    public LabelCriteria forThe(final Label label) {
        return new LabelCriteria(label, this);
    }

    /**
     * @param link control to element Criteria for.
     * @return LinkCriteria.
     */
    public LinkCriteria forThe(final Link link) {
        return new LinkCriteria(link, this);
    }

    /**
     * @param textInput control to element Criteria for.
     * @return TextInputCriteria.
     */
    public TextInputCriteria forThe(final TextInput textInput) {
        return new TextInputCriteria(textInput, this);
    }

    /**
     * @param button control to element Criteria for.
     * @return ButtonCriteria.
     */
    public ButtonCriteria forThe(final Button button) {
        return new ButtonCriteria(button, this);
    }

    /**
     * @param string control to element Criteria for.
     * @return ButtonCriteria.
     */
    public StringCriteria forThe(final String string) {
        return StringCriteria.get(string, this);
    }

    /**
     * @param list controls list to element Criteria for.
     * @return ListCriteria.
     */
    public ListCriteria forThe(final List list) {
        return new ListCriteria(list, this);
    }

    /**
     * @param digit Double to element Criteria for.
     * @return DigitCriteria.
     */
    public DigitCriteria forThe(final Double digit) {
        return new DigitCriteria(digit, this);
    }

    /**
     * @param aBoolean to element Criteria for.
     * @return BooleanCriteria.
     */
    public BooleanCriteria forThe(final boolean aBoolean) {
        return new BooleanCriteria(aBoolean, this);
    }

    /**
     * @param anAlert to element Criteria for.
     * @return AlertCriteria
     */
    public AlertCriteria forThe(final Alert anAlert) {
        return new AlertCriteria(anAlert, this);
    }

}
